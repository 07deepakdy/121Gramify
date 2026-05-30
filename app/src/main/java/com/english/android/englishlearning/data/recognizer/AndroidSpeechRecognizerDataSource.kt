package com.english.android.englishlearning.data.recognizer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import com.english.android.englishlearning.domain.model.SpeechResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.Locale

class AndroidSpeechRecognizerDataSource(
    context: Context
) : SpeechRecognizerDataSource {

    private val _results = MutableSharedFlow<SpeechResult>(extraBufferCapacity = 1)
    private val recognizer = SpeechRecognizer.createSpeechRecognizer(context)

    private val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
        putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale("en","IN"))
        putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,
            "en-IN"
        )

        putExtra(
            RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE,
            false
        )
    }

    init {

        Log.e("DEBUG_STT","recognition available = ${SpeechRecognizer.isRecognitionAvailable(context)}")

        recognizer.setRecognitionListener(object : RecognitionListener {

            override fun onReadyForSpeech(params: Bundle?) {
               // println("DEBUG_STT: onReadyForSpeech")
                Log.e("DEBUG_STT","onReadyForSpeech")
            }

            override fun onBeginningOfSpeech() {
               // println("DEBUG_STT: onBeginningOfSpeech")
                Log.e("DEBUG_STT","onBeginningOfSpeech")
            }

            override fun onRmsChanged(rmsdB: Float) {
               // println("DEBUG_STT: rms=$rmsdB")
                Log.e("DEBUG_STT","rms=$rmsdB")

            }

            override fun onPartialResults(bundle: Bundle?) {
                val text = bundle
                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull()

               // println("DEBUG_STT: partial=$text")
                Log.e("DEBUG_STT","partial={$text}")

                text?.let {
                    _results.tryEmit(SpeechResult.Partial(it))
                }
            }

            override fun onResults(bundle: Bundle?) {
                val text = bundle
                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull()

               // println("DEBUG_STT: final=$text")
                Log.e("DEBUG_STT","final={$text}")

                text?.let {
                    _results.tryEmit(SpeechResult.Final(it))
                }
            }

            override fun onError(error: Int) {
                println("DEBUG_STT: error=$error (${error.toReadableMessage()})")
                Log.e("DEBUG_STT","final={${error.toReadableMessage()}}")


                _results.tryEmit(
                    SpeechResult.Error(error.toReadableMessage())
                )
            }

            override fun onBufferReceived(buffer: ByteArray?) {}

            override fun onEndOfSpeech() {
                println("DEBUG_STT: onEndOfSpeech")
                Log.e("DEBUG_STT","onEndOfSpeech")

            }

            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
    }


    override fun start() {
       Log.e("DEBUG_STT","startListening called")
        recognizer.startListening(intent)
    }

    override fun stop() {
        Log.e("DEBUG_STT","stopListening called")
        recognizer.stopListening()
    }

    override fun results(): Flow<SpeechResult> = _results
}


fun Int.toReadableMessage(): String {
    return when (this) {
        SpeechRecognizer.ERROR_AUDIO ->
            "Audio recording error"
        SpeechRecognizer.ERROR_CLIENT ->
            "Client side error"
        SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS ->
            "Microphone permission denied"
        SpeechRecognizer.ERROR_NETWORK ->
            "Network error"
        SpeechRecognizer.ERROR_NETWORK_TIMEOUT ->
            "Network timeout"
        SpeechRecognizer.ERROR_NO_MATCH ->
            "No speech recognized"
        SpeechRecognizer.ERROR_RECOGNIZER_BUSY ->
            "Speech recognizer busy"
        SpeechRecognizer.ERROR_SERVER ->
            "Server error"
        SpeechRecognizer.ERROR_SPEECH_TIMEOUT ->
            "Speech input timeout"
        else ->
            "Unknown speech recognition error"
    }
}
