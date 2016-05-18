package ru.finnetrolle.devourer.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.finnetrolle.devourer.model.Spot
import ru.finnetrolle.devourer.model.SpotRepository
import ru.finnetrolle.devourer.restful.SpotRestIn
import java.text.SimpleDateFormat

@Component
class SpotService {

    @Autowired
    lateinit var repository: SpotRepository

    interface Result {
        data class AddSuccess(val spot: Spot) : Result
        data class AddFailed(val errorDescription: String) : Result
    }

    fun add(data: SpotRestIn): Result {
        try {
            val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            val date = sdf.parse(data.timestamp)
            val spot: Spot = Spot(imei = data.imei, accuracy = data.accuracy, eps = data.eps, lat = data
                    .lat, lon = data.lon, phone = data.phone, speed = data.speed, timestamp = date, workStatus = data.workStatus)
            repository.save(spot)
            return Result.AddSuccess(spot)
        } catch (e: Exception) {
            return Result.AddFailed(e.message!!)
        }
    }

}