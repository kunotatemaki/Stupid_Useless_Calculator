package com.rukiasoft.stupiduselesscalculator

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.rukiasoft.stupiduselesscalculator.databinding.MainActivityBinding
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber

class MainActivity : DaggerAppCompatActivity() {

    lateinit var binding: MainActivityBinding
    private lateinit var mInterstitialAd: InterstitialAd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        val adRequest = AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build()
        binding.adView.loadAd(adRequest)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-8409265947000941/3074650164"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                mInterstitialAd.loadAd(AdRequest.Builder().build())
            }
        }
    }

    fun loadAd(){
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        } else {
            Timber.d("The interstitial wasn't loaded yet.")
        }
    }

}
