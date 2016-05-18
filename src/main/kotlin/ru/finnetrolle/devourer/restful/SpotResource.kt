package ru.finnetrolle.devourer.restful

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import ru.finnetrolle.devourer.model.Accuracy
import ru.finnetrolle.devourer.model.WorkStatus
import ru.finnetrolle.devourer.service.SpotService

/**
 * This class is developed by maxsyachin on 18.05.16
 * for devourer in version ru.finnetrolle.devourer.restful
 * under MIT license
 */

@Component
@RequestMapping("spot")
class SpotResource {

    @Autowired
    lateinit var service: SpotService

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun receive(@RequestBody spot: SpotRestIn): ResponseEntity<Void> {
        val result = service.add(spot)
        when (result) {
            is SpotService.Result.AddFailed -> return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            is SpotService.Result.AddSuccess -> return ResponseEntity.ok().build()
            else -> return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    companion object {
        val log = LoggerFactory.getLogger(SpotResource::class.java)
    }

}

data class SpotRestIn(
        var imei: String = "",
        var timestamp: String = "",
        var lat: Double = 0.0,
        var lon: Double = 0.0,
        var speed: Double = 0.0,
        var eps: Double = 0.0,
        var accuracy: Accuracy = Accuracy.COARSE,
        var phone: String = "",
        var workStatus: WorkStatus = WorkStatus.NOT_WORKING
)

