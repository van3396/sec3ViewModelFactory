package sec3viewmodelfactory.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import sec3viewmodelfactory.com.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelFactory = MainFactory(100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.apply {
            totalTv.text = viewModel.getTotal().toString()

            totalBtn.setOnClickListener{
                viewModel.setTotal(addNumberEt.text.toString().toInt())
                totalTv.text = viewModel.getTotal().toString()
            }
        }
    }
}