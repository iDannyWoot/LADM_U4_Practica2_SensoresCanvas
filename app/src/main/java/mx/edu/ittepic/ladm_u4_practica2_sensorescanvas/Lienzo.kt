package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat.getSystemService

class Lienzo (p: MainActivity): View(p), SensorEventListener {

    private lateinit var sensorManager: SensorManager

    var bruja =BitmapFactory.decodeResource(resources,R.drawable.bruja)
    var luna = BitmapFactory.decodeResource(resources,R.drawable.luna)
    var nube = BitmapFactory.decodeResource(resources,R.drawable.nube)
    var sol = BitmapFactory.decodeResource(resources,R.drawable.sol)

    override fun onSensorChanged(p0: SensorEvent?) {

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        //fondo
        c.drawColor(Color.rgb(0,0,139))

        //nubes

        c.drawBitmap(nube,-350f,150f,p)
        c.drawBitmap(nube,400f,150f,p)

        //luna
         c.drawBitmap(luna,-80f,700f,p)

        //sol
        //c.drawBitmap(sol,-80f,700f,p)

        //imagen de bruja
        c.drawBitmap(bruja,300f,400f,p)

    }



}