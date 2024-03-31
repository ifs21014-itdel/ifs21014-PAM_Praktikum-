package com.ifs21014.pampraktikum8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.ifs21014.pampraktikum8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupView() {
        binding.navView.setCheckedItem(R.id.navigation_dashboard)

        binding.inAppBar.toolbar.overflowIcon =
            ContextCompat.getDrawable(this, R.drawable.ic_more_vert)

        loadFragment(FLAG_FRAGMENT_DASHBOARD)
    }

    private fun setupAction() {
        binding.inAppBar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                // Handle menu item clicks here
                else -> true
            }
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_allInbox -> {
                    loadFragment(FLAG_FRAGMENT_ALL_INBOX, "Memilih menu All Inbox!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_utama -> {
                    loadFragment(FLAG_FRAGMENT_UTAMA, "Memilih menu Utama!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_promosi -> {
                    loadFragment(FLAG_FRAGMENT_PROMOSI, "Memilih menu Promosi!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_sosial -> {
                    loadFragment(FLAG_FRAGMENT_SOSIAL, "Memilih menu Sosial!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_berbintang -> {
                    loadFragment(FLAG_FRAGMENT_BERBINTANG, "Memilih menu Berbintang!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_ditunda -> {
                    loadFragment(FLAG_FRAGMENT_DITUNDA, "Memilih menu Ditunda!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }


                else -> true

            }

        }

        binding.inAppBar.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD)
                    true
                }
                R.id.navigation_notifications -> {
                    loadFragment(FLAG_FRAGMENT_NOTIFICATION)
                    true
                }
                else -> true
            }
        }
    }

    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId = binding.inAppBar.inContentMain.frameContainer.id

        when (flag) {
            FLAG_FRAGMENT_DASHBOARD -> {
                val dashboardFragment = DashboardFragment()
                val fragment = fragmentManager.findFragmentByTag(DashboardFragment::class.java.simpleName)

                if (fragment !is DashboardFragment) {
                    fragmentManager.beginTransaction()
                        .replace(
                            fragmentContainerId,
                            dashboardFragment,
                            DashboardFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_NOTIFICATION -> {
                val notificationFragment = NotificationFragment()
                val fragment = fragmentManager.findFragmentByTag(NotificationFragment::class.java.simpleName)

                if (fragment !is NotificationFragment) {
                    fragmentManager.beginTransaction()
                        .replace(
                            fragmentContainerId,
                            notificationFragment,
                            NotificationFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_ALL_INBOX -> {
                val allInboxFragment = AllInboxFragment()
                val fragment = fragmentManager.findFragmentByTag(AllInboxFragment::class.java.simpleName)

                if (fragment !is AllInboxFragment) {
                    fragmentManager.beginTransaction()
                        .replace(
                            fragmentContainerId,
                            allInboxFragment,
                            AllInboxFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_UTAMA -> {
                val utamaFragment = UtamaFragment()
                val fragment = fragmentManager.findFragmentByTag(UtamaFragment::class.java.simpleName)

                if (fragment !is UtamaFragment) {
                    fragmentManager.beginTransaction()
                        .replace(
                            fragmentContainerId,
                            utamaFragment,
                            UtamaFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_PROMOSI -> {
                val promosiFragment = PromosiFragment()
                val fragment = fragmentManager.findFragmentByTag(UtamaFragment::class.java.simpleName)

                if (fragment !is PromosiFragment) {
                    fragmentManager.beginTransaction()
                        .replace(
                            fragmentContainerId,
                            promosiFragment,
                            PromosiFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_SOSIAL -> {
                val sosialFragment = SosialFragment()
                val fragment = fragmentManager.findFragmentByTag(UtamaFragment::class.java.simpleName)

                if (fragment !is SosialFragment) {
                    fragmentManager.beginTransaction()
                        .replace(
                            fragmentContainerId,
                            sosialFragment,
                            SosialFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_BERBINTANG -> {
                val berbintangFragment = BerbintangFragment()
                val fragment = fragmentManager.findFragmentByTag(UtamaFragment::class.java.simpleName)

                if (fragment !is BerbintangFragment) {
                    fragmentManager.beginTransaction()
                        .replace(
                            fragmentContainerId,
                            berbintangFragment,
                            BerbintangFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_DITUNDA -> {
                val ditundaFragment = DitundaFragment()
                val fragment = fragmentManager.findFragmentByTag(UtamaFragment::class.java.simpleName)

                if (fragment !is BerbintangFragment) {
                    fragmentManager.beginTransaction()
                        .replace(
                            fragmentContainerId,
                            ditundaFragment,
                            DitundaFragment::class.java.simpleName
                        )
                        .commit()
                }
            }

        }
    }

    companion object {
        const val FLAG_FRAGMENT_DASHBOARD = "fragment_dashboard"
        const val FLAG_FRAGMENT_NOTIFICATION = "fragment_notification"
        const val FLAG_FRAGMENT_ALL_INBOX = "fragment_all_inbox"
        const val FLAG_FRAGMENT_UTAMA ="fragment_utama"
        const val FLAG_FRAGMENT_PROMOSI = "fragment_promosi"
        const val FLAG_FRAGMENT_SOSIAL = "fragment_sosial"
        const val FLAG_FRAGMENT_BERBINTANG = "fragment_berbintang"
        const val FLAG_FRAGMENT_DITUNDA= "fragment_ditunda"
    }
}
