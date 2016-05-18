package ru.finnetrolle.devourer.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.repository.CrudRepository
import java.util.*
import javax.persistence.*

/**
 * This class is developed by maxsyachin on 18.05.16
 * for devourer in version ru.finnetrolle.devourer.restful
 * under MIT license
 */

interface SpotRepository : CrudRepository<Spot, Long> {}

@Entity
@Table(name = "spots")
data class Spot(
        @Id
        @Column(name = "spot_id")
        @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "spot_id_seq")
        @GenericGenerator(name = "spot_id_seq", strategy = "enhanced-sequence", parameters = arrayOf(
                org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.SequenceStyleGenerator.SEQUENCE_PARAM, value = "spot_id_seq"),
                org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.SequenceStyleGenerator.OPT_PARAM, value = "pooled_lo"),
                org.hibernate.annotations.Parameter(name = org.hibernate.id.enhanced.SequenceStyleGenerator.INCREMENT_PARAM, value = "1")
        ))
        var id: Long = 0L,
        @Column(name = "imei") var imei: String = "",
        @Column(name = "spot_timestamp") var timestamp: Date = Date(),
        @Column(name = "lat") var lat: Double = 0.0,
        @Column(name = "lon") var lon: Double = 0.0,
        @Column(name = "speed") var speed: Double = 0.0,
        @Column(name = "eps") var eps: Double = 0.0,
        @Column(name = "accuracy") var accuracy: Accuracy = Accuracy.COARSE,
        @Column(name = "phone") var phone: String = "",
        @Column(name = "work_status") var workStatus: WorkStatus = WorkStatus.NOT_WORKING
)

enum class Accuracy {
    LAST_KNOWN,
    COARSE,
    FINE
}

enum class WorkStatus {
    WORKING,
    NOT_WORKING
}

