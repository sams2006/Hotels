package com.tuwiq.hotels.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tuwiq.hotels.model.Hotel
import kotlinx.coroutines.DEBUG_PROPERTY_VALUE_OFF
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val AddBREAKFAST = 20

class SharedViewModel: ViewModel() {


    val dateOptions = getArrivalOptions()

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

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

    private val _quantity =MutableLiveData<Int>(1)
    val quantity :LiveData<Int> get() = _quantity

    private val _total =MutableLiveData<Int>()
    var total: LiveData<String> = Transformations.map(_total) {
        // Format the price into the local currency and return this as LiveData<String>
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _room = MutableLiveData<Int>(1)
    val room :LiveData<Int>  get() = _room

    private val _breakfast = MutableLiveData<Int>(0)
    val breakfast:LiveData<Int> get() = _breakfast


    fun setDate(pickupDate: String){
        _date.value = pickupDate
        updatePrice()
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
    fun setRoom(numOfRoom: Int) {
        _room.value = numOfRoom
       updatePrice()
    }

    fun updatePrice() {
      _total.value = ( _price.value!!)?.times(_quantity.value!!)?.times(_room.value!!)?.plus(
          _breakfast.value!!)

    }


    fun hasNoQuantitySet() : Boolean{
        return _quantity.value.toString().isNullOrBlank()
    }

   fun hasNoRoomSet(): Boolean {
       return _room.value.toString().isNullOrBlank()
   }

   fun setBreakfast(fast: Int) {
       _breakfast.value = fast
       updatePrice()
   }

    // Date options + Date Formatting
    private fun getArrivalOptions(): List<String>{
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(6){
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    fun resetOrder() {
        _nameCity.value=""
        _nameHotel.value = ""
        _quantity.value = 0
        _room.value = 0
        _date.value = dateOptions[0]
       _total.value = 0
        _breakfast.value = 0
    }



}
