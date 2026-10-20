package bo.edu.uajms.sistemasbermejo.programacionmovil.aramayofernando.surmarket.models

import android.R

data class product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val imageUrl: String,
    val description: String,
    val available: Boolean,
    val stock: Int
)