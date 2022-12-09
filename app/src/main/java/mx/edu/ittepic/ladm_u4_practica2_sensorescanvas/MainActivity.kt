package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas

import android.graphics.*
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.drawToBitmap

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setUpSensorStuff()

        var bruja = BitmapFactory.decodeResource(resources,R.drawable.bruja)
        var luna = BitmapFactory.decodeResource(resources,R.drawable.luna)
        var nube = BitmapFactory.decodeResource(resources,R.drawable.nube)
        var sol = BitmapFactory.decodeResource(resources,R.drawable.sol)

        var canvas = Lienzo(this)
        var canvas2 = Canvas()
        var p = Paint()
        //fondo
        canvas.dibujarColor(canvas2, Color.rgb(0,0,139))

        //nubes

        canvas.dibujarImagen(canvas2,nube,-350f,150f,p)
        canvas.dibujarImagen(canvas2,nube,400f,150f,p)

        //luna
        canvas.dibujarImagen(canvas2,luna,-80f,700f,p)

        //sol
        //c.drawBitmap(sol,-80f,700f,p)

        //imagen de bruja
        canvas.dibujarImagen(canvas2,bruja,300f,400f,p)
        setContentView(canvas)



    }

    private fun setUpSensorStuff() {
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also{
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_FASTEST, SensorManager.SENSOR_DELAY_FASTEST)
        }

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            val sides = event.values[0]
            val upDown = event.values[1]


        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    class Lienzo (p: MainActivity): View(p) {


        override fun onDraw(c: Canvas) {
            super.onDraw(c)

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

        fun dibujarColor(canvas: Canvas,c :Int){
            this.drawColor(c)
        }



        private fun drawBitmap(imagen: Bitmap, left: Float, top: Float, p: Paint) {

        }

    }
}