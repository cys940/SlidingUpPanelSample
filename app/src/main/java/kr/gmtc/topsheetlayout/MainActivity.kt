package kr.gmtc.topsheetlayout


import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState
import kr.gmtc.topsheetlayout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel: StringViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding?>(
            this,
            R.layout.activity_main
        ).apply {
            lifecycleOwner = this@MainActivity
            stringViewModel = viewModel
        }

        AnimationUtils.loadAnimation(
            this,
            R.anim.move
        ).apply {
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animaion: Animation) {
                    Log.d("TAG", "onAnimationStart")
                }

                override fun onAnimationEnd(animaion: Animation) {
                    Log.d("TAG", "onAnimationEnd")
                }

                override fun onAnimationRepeat(animaion: Animation) {
                    Log.d("TAG", "onAnimationRepeat")
                }
            })
        }.also {
            binding.message.startAnimation(it)
        }

        val adapter = StringAdapter()
        for (i in viewModel.items.value!!) {
            adapter.addItem(i)
        }
        binding.recyclerview.adapter = adapter
        binding.recyclerview.setHasFixedSize(false)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        binding.slidingLayout.apply {
            addPanelSlideListener(object :SlidingUpPanelLayout.PanelSlideListener{
                override fun onPanelSlide(panel: View?, slideOffset: Float) {
                    binding.normal.visibility = View.GONE
                }

                override fun onPanelStateChanged(
                    panel: View?,
                    previousState: SlidingUpPanelLayout.PanelState?,
                    newState: SlidingUpPanelLayout.PanelState?
                ) {
                    if(newState == PanelState.EXPANDED)
                        viewModel.setExpand(true)
                    else
                        viewModel.setExpand(false)
                }
            })
            setScrollableView(binding.recyclerview)
        }

        viewModel.isExpand.observe(this){
            if (it){
                binding.detail.visibility = View.VISIBLE
                binding.normal.visibility = View.GONE
            } else {
                binding.detail.visibility = View.GONE
                binding.normal.visibility = View.VISIBLE
            }
        }

        viewModel.items.observe(this){
            for (i in viewModel.items.value!!) {
                adapter.addItem(i)
            }
        }
    }

}