package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorSpace.Rgb
import android.graphics.Paint
import android.view.View

class Lienzo (p: MainActivity): View(p) {

    var bruja =BitmapFactory.decodeResource(resources,R.drawable.bruja)
    var luna = BitmapFactory.decodeResource(resources,R.drawable.luna)
    var nube = BitmapFactory.decodeResource(resources,R.drawable.nube)
    var sol = BitmapFactory.decodeResource(resources,R.drawable.sol)


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()


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