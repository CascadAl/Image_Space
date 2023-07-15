package com.example.imagespace.ui.main

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.core.view.WindowCompat
import androidx.core.view.forEach
import androidx.core.view.marginBottom
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.imagespace.R
import com.example.imagespace.databinding.ActivityMainBinding
import com.example.imagespace.ui.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)

        setupNavView()
//        binding.navView.menuView
//        val menuItem = binding.navView.menu.findItem(R.id.add_photo)
////        LayoutInflater.from(this).inflate(R.layout.test, binding.navView, true)
////        menuItem.actionView = customItem
//
//        menuItem.setIcon(R.drawable.ic_add_photo)
//        menuItem.actionView?.apply {
//            updateLayoutParams {
//                width = 50
//                height = 50
//            }
//        }
////        val title = binding.navView.menu.findItem(R.id.add_photo).title
////        toast(title.toString())
////        val lp = view?.layoutParams
////        lp?.width = 120
////        view?.layoutParams = lp
    }

    private fun setupNavView() = with(binding) {
//        navView.menu.findItem(R.id.add_photo).icon?.setTintMode(PorterDuff.Mode.SRC_IN)
//        navView.menu.findItem(R.id.add_photo).setIcon(R.drawable.ic_chat)
        binding.navView.itemIconTintList = null


        (binding.navView.getChildAt(0) as BottomNavigationMenuView).forEach {
            if (it is BottomNavigationItemView) {
                val iconView: View =
                    it.findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view)
                val displayMetrics = resources.displayMetrics
                iconView.layoutParams.width = WRAP_CONTENT
//            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 38f, displayMetrics).toInt()
                iconView.layoutParams.height = WRAP_CONTENT

                val iconContainerView: View =
                    it.findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container)
                iconContainerView.layoutParams.width = WRAP_CONTENT
                iconContainerView.layoutParams.height = WRAP_CONTENT
//                iconContainerView.setBackgroundColor(resources.getColor(R.color.primary_button_color, null))
            }
        }

//        val itemView =
//            (binding.navView.getChildAt(0) as BottomNavigationMenuView).getChildAt(2) as BottomNavigationItemView // icon index
//
//        val iconView: View =
//            itemView.findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view)
//        val displayMetrics = resources.displayMetrics
//        iconView.layoutParams.width = MATCH_PARENT
////            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 38f, displayMetrics).toInt()
//        iconView.layoutParams.height = MATCH_PARENT
//
//        val iconContainerView: View =
//            itemView.findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container)
//        iconContainerView.layoutParams.width = WRAP_CONTENT
//        iconContainerView.layoutParams.height = WRAP_CONTENT
    }
}