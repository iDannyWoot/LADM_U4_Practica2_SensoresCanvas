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

class Lienzo (private val p: MainActivity): View(p) {
    val paint = Paint()
    val bruja = BitmapFactory.decodeResource(resources, R.drawable.bruja)
    val luna = BitmapFactory.decodeResource(resources, R.drawable.luna)
    val sol = BitmapFactory.decodeResource(resources, R.drawable.sol)
    val nubes = BitmapFactory.decodeResource(resources, R.drawable.nube)

    val azul = "#ADD8E6"
    val azulOscuro = "#252850"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (p.noche) {
            noche(canvas)
        } else {
            dia(canvas)
        }
    }

    private fun dia(canvas: Canvas) {
        canvas.drawColor(Color.parseColor(azul))
        val gx = p.gx * 100
        val gy = p.gy * 100
        canvas.drawBitmap(
            sol,
            width / 2f - sol.width / 2f + gy,
            height / 2f - sol.height / 2f + gx,
            paint
        )
        canvas.drawBitmap(nubes, width / 2f - nubes.width / 2f + gy, gx, paint)
        canvas.drawBitmap(
            bruja,
            width / 2f - bruja.width / 2f,
            height / 2f - bruja.height / 2f,
            paint
        )
    }

    private fun noche(canvas: Canvas) {
        canvas.drawColor(Color.parseColor(azulOscuro))
        val gx = p.gx * 100
        val gy = p.gy * 100
        canvas.drawBitmap(
            luna,
            width / 2f - luna.width / 2f + gy,
            height / 2f - luna.height / 2f + gx,
            paint
        )
        canvas.drawBitmap(nubes, width / 2f - nubes.width / 2f + gy, gx, paint)
        canvas.drawBitmap(
            bruja,
            width / 2f - bruja.width / 2f,
            height / 2f - bruja.height / 2f,
            paint
        )
    }
}