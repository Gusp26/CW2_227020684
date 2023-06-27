package com.example.cw2_227020684

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MpActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap:GoogleMap
    private lateinit var mMap2:GoogleMap

    val cc = LatLng(22.212059,114.0246611)
    val p1 = LatLng(22.2474113,114.1660458)
    val p2 = LatLng(22.2190437,114.2066917)
    val p3 = LatLng(22.2494062,114.1372775)
    val p4 = LatLng(22.2489922,114.1351283)
    val p5 = LatLng(22.2791722,114.1248248)
    val p6 = LatLng(22.2859304,114.1387466)
    val p7 = LatLng(22.2629459,114.2356101)
    val p8 = LatLng(22.2787064,114.2248779)
    val p9 = LatLng(22.3235871,114.2151918)
    val p10 = LatLng(22.3003249,114.2340881)
    val p11 = LatLng(22.3093463,114.2337181)
    val p12 = LatLng(22.3255288,114.216102)
    val p13 = LatLng(22.3497495,114.1982087)
    val p14 = LatLng(22.326626,114.1861841)
    val p15 = LatLng(22.327822,114.1608618)
    val p16 = LatLng(22.3391864,114.1574678)
    val p17 = LatLng(22.3667167,114.1249519)


    private var locationArrayList: ArrayList<LatLng>? = null
    private var locationArrayList2: ArrayList<LatLng>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mp)

        val map = supportFragmentManager.findFragmentById(R.id.myMap) as SupportMapFragment
        map.getMapAsync(this)

        locationArrayList = ArrayList()

        locationArrayList!!.add(cc)

        locationArrayList2 = ArrayList()

        locationArrayList2!!.add(p1)
        locationArrayList2!!.add(p2)
        locationArrayList2!!.add(p3)
        locationArrayList2!!.add(p4)
        locationArrayList2!!.add(p5)
        locationArrayList2!!.add(p6)
        locationArrayList2!!.add(p7)
        locationArrayList2!!.add(p8)
        locationArrayList2!!.add(p9)
        locationArrayList2!!.add(p10)
        locationArrayList2!!.add(p11)
        locationArrayList2!!.add(p12)
        locationArrayList2!!.add(p13)
        locationArrayList2!!.add(p14)
        locationArrayList2!!.add(p15)
        locationArrayList2!!.add(p16)
        locationArrayList2!!.add(p17)

    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        mMap2 = googleMap

        for (i in locationArrayList!!.indices){

            mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Cheung Chau Da Jiu Festival"))
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!!.get(i)))

        }

        for (i in locationArrayList2!!.indices){

            mMap2.addMarker(MarkerOptions().position(locationArrayList2!![i]).title("Yu Lan Festival"))
            mMap2.animateCamera(CameraUpdateFactory.zoomTo(18.0f))
            mMap2.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList2!!.get(i)))

        }
    }
}