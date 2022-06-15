package kr.gmtc.topsheetlayout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
val sample = listOf<String>(
    "PAGA 알람 발생",
    "PHONE 알람 발생",
    "화재 알람 발생",
    "기관실 알람 발생",
    "PAGA 알람 발생",
    "PHONE 알람 발생",
    "화재 알람 발생",
    "기관실 알람 발생",
    "PAGA 알람 발생",
    "PHONE 알람 발생",
    "화재 알람 발생",
    "기관실 알람 발생",
    "PAGA 알람 발생",
    "PHONE 알람 발생",
    "화재 알람 발생",
    "기관실 알람 발생",
    "PAGA 알람 발생",
    "PHONE 알람 발생",
    "화재 알람 발생",
    "기관실 알람 발생",
    "PAGA 알람 발생",
    "PHONE 알람 발생",
    "화재 알람 발생",
    "기관실 알람 발생",
    "PAGA 알람 발생",
    "PHONE 알람 발생",
    "화재 알람 발생",
    "기관실 알람 발생",
    "PAGA 알람 발생",
    "PHONE 알람 발생",
    "화재 알람 발생",
    "기관실 알람 발생",
)
class StringViewModel: ViewModel() {
    private val _items: MutableLiveData<List<String>> = MutableLiveData<List<String>>()
    val items:LiveData<List<String>>
        get() = _items

    private val _isExpand:MutableLiveData<Boolean> = MutableLiveData()
    val isExpand:LiveData<Boolean>
        get() = _isExpand

    init {
        _items.value = sample
        _isExpand.value = false
    }

    fun setExpand(isExpand:Boolean){
        _isExpand.value = isExpand
    }
}