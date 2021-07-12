package kr.co.bepo.deliverytracker.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kr.co.bepo.deliverytracker.data.entity.*
import kotlin.random.Random
import kotlin.random.nextLong

class TrackingItemRepositoryStub : TrackingItemRepository {

    override val trackingItems: Flow<List<TrackingItem>> = flowOf(emptyList())

    //    override suspend fun getTrackingItemInformation(): List<Pair<TrackingItem, TrackingInformation>> =
//        (1_000_000..1_000_020)
//            .map { it.toString() }
//            .map { invoice ->
//                val currentTimeMillis = System.currentTimeMillis()
//                TrackingItem(invoice, ShippingCompany("1", "택배회사")) to
//                        TrackingInformation(
//                            invoiceNo = invoice,
//                            itemName = if (Random.nextBoolean()) "이름 있음" else null,
//                            level = Level.values().random(),
//                            lastDetail = TrackingDetail(
//                                kind = "상하차",
//                                where = "역삼역",
//                                time = Random.nextLong(
//                                    currentTimeMillis - 1000L * 60L * 60L * 24L * 20L..currentTimeMillis
//                                )
//                            )
//                        )
//            }
//            .sortedWith(
//                compareBy(
//                    { it.second.level },
//                    { -(it.second.lastDetail?.time ?: Long.MAX_VALUE) }
//                )
//            )

    override suspend fun getTrackingItemInformation(): List<Pair<TrackingItem, TrackingInformation>> =
        listOf(
            TrackingItem("1", ShippingCompany("1", "대한통운")) to TrackingInformation(
                itemName = "운동화",
                level = Level.START
            ),
            TrackingItem("2", ShippingCompany("1", "대한통운")) to TrackingInformation(
                itemName = "장난감",
                level = Level.START
            ),
            TrackingItem("3", ShippingCompany("1", "대한통운")) to TrackingInformation(
                itemName = "의류",
                level = Level.START
            ),
            TrackingItem("4", ShippingCompany("1", "대한통운")) to TrackingInformation(
                itemName = "가전",
                level = Level.START
            ),
            TrackingItem(
                "5",
                ShippingCompany("1", "대한통운")
            ) to TrackingInformation(itemName = "음반/DVD", level = Level.ON_TRANSIT),
            TrackingItem("6", ShippingCompany("1", "대한통운")) to TrackingInformation(
                itemName = "도서",
                level = Level.COMPLETE
            )
        )

    override suspend fun getTrackingInformation(
        companyCode: String,
        invoice: String
    ): TrackingInformation? = null

    override suspend fun saveTrackingItem(trackingItem: TrackingItem) = Unit

    override suspend fun deleteTrackingItem(trackingItem: TrackingItem) = Unit
}