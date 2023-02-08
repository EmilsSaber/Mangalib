package kg.example.mangalib.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kg.example.mangalib.domein.utils.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB: ViewBinding> :Fragment() {


    lateinit var binding:VB

    abstract fun inflate(layoutInflater: LayoutInflater):VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }
    open  fun initView() {}
    open fun initListener(){}




    protected fun <T> StateFlow<UiState<T>>.collectState(
        onLoading: ()->Unit,
        Error:(message:String)-> Unit,
        onSuccess:(data:T) ->Unit
    ){
lifecycleScope.launch {
    repeatOnLifecycle(Lifecycle.State.STARTED) {
        this@collectState.collect { state ->
            when (state) {
                is UiState.Loading -> {
                    onLoading()
                }
                is UiState.Error -> {
                    Error(state.message)
                }
                is UiState.Success -> {
                    onSuccess(state.data)
                }
                is UiState.Empty -> {

                }
            }

        }
    }

}
    }
}