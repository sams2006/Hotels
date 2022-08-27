package com.tuwiq.hotels.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tuwiq.hotels.model.Hotel
import kotlinx.coroutines.DEBUG_PROPERTY_VALUE_OFF
import java.text.NumberFormat

class SharedViewModel: ViewModel() {

    private val _nameHotel = MutableLiveData<String>()
            val nameHotel :LiveData<String>  get() = _nameHotel

    private val _imageHotel = MutableLiveData<Int>()
    val imageHotel :LiveData<Int>  get() = _imageHotel

    private val _nameCity = MutableLiveData<String>()
    val nameCity :LiveData<String>  get() = _nameCity

    private val _price = MutableLiveData<Int>()
    var price: LiveData<String> = Transformations.map(_price) {
        // Format the price into the local currency and return this as LiveData<String>
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _quantity =MutableLiveData<Int>()
    val quantity :LiveData<Int> get() = _quantity

    private val _total =MutableLiveData<Int>()
    var total: LiveData<String> = Transformations.map(_total) {
        // Format the price into the local currency and return this as LiveData<String>
        NumberFormat.getCurrencyInstance().format(it)
    }



    fun getNameHotel(name:String) {
     _nameHotel.value = name
 }
    fun getNameCity(name:String) {
        _nameCity.value = name
    }

    fun getImage(image:Int) {
        _imageHotel.value = image
    }

    fun getPrice(price:Int) {
        _price.value = price


    }

    fun setQuantity(numOfNight: Int) {
        _quantity.value = numOfNight
      updatePrice()

    }

   private fun updatePrice() {
      _total.value = ( _price.value)?.times((_quantity.value!!))

    }


    fun hasNoQuantitySet() : Boolean{
        return _quantity.value.toString().isNullOrBlank()
    }



}
