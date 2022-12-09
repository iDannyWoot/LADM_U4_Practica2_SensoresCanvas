package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private lateinit var mProximity: Sensor
    private lateinit var giroscope: Sensor
    private lateinit var canva: Lienzo

    var noche = true
    var iniciado = false
    var gx = 0f
    var gy = 0f
    var gz = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        canva = Lienzo(this)
        setContentView(canva)
        iniciado = true
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        giroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
    }

    override fun onSensorChanged(evento: SensorEvent) {
        if (evento.sensor.stringType.equals(giroscope.stringType)) logicaGiroscopio(
            evento.values,
        )
        if (evento.sensor.stringType.equals(mProximity.stringType)) logicaProximidad(evento.values)
    }

    private fun logicaProximidad(valores: FloatArray) {
        val distance = valores[0]

        noche = distance < 5
        if (iniciado) canva.invalidate()
    }

    private fun logicaGiroscopio(valores: FloatArray) {
        gx = valores[0]
        gy = valores[1]
        gz = valores[2]
        if (iniciado) canva.invalidate()
    }

    override fun onResume() {
        super.onResume()
        mProximity.also { proximity ->
            sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL)
        }
        giroscope.also { giro ->
            sensorManager.registerListener(this, giro, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}