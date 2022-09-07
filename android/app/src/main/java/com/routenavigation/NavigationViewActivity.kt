package com.routenavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.navigation.base.ExperimentalPreviewMapboxNavigationAPI
import com.routenavigation.databinding.MapboxActivityNavigationViewBinding
import androidx.appcompat.app.AppCompatDelegate
import android.content.res.Configuration

/**
 * The example uses replay location engine to facilitate navigation without physically moving.
 */
@OptIn(ExperimentalPreviewMapboxNavigationAPI::class)
class NavigationViewActivity : AppCompatActivity() {

    private lateinit var binding: MapboxActivityNavigationViewBinding
    private var themeMode: CurrentTheme? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val publicKey: String = getIntent().getStringExtra("publicKey").toString()

        binding = MapboxActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // This allows to simulate your location -Kapatırız sonra.
        binding.navigationView.api.enableReplaySession()


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())
        themeMode = when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                CurrentTheme(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else -> {
                CurrentTheme(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        binding.toggleTheme.setOnClickListener {
            if (themeMode?.theme == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }


    }
}
data class CurrentTheme(val theme: Int)