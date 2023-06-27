package com.example.cw2_227020684

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap:GoogleMap

    val cc = LatLng(22.2111337,114.0262734)
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

    private var locationArrayList:ArrayList<LatLng>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val map = supportFragmentManager.findFragmentById(R.id.myMap) as SupportMapFragment
        map.getMapAsync(this)

        locationArrayList = ArrayList()

        locationArrayList!!.add(cc)
        locationArrayList!!.add(p1)
        locationArrayList!!.add(p2)
        locationArrayList!!.add(p3)
        locationArrayList!!.add(p4)
        locationArrayList!!.add(p5)
        locationArrayList!!.add(p6)
        locationArrayList!!.add(p7)
        locationArrayList!!.add(p8)
        locationArrayList!!.add(p9)
        locationArrayList!!.add(p10)
        locationArrayList!!.add(p11)
        locationArrayList!!.add(p12)
        locationArrayList!!.add(p13)
        locationArrayList!!.add(p14)
        locationArrayList!!.add(p15)
        locationArrayList!!.add(p16)
        locationArrayList!!.add(p17)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        for ( i in locationArrayList!!.indices) {

            mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Marker"))
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!!.get(i)))

        }
    }
}