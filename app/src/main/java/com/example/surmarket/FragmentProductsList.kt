package com.example.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class FragmentProductsList : Fragment() {

    private lateinit var IMV_FRGProductsList_ShoppingCart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETX_FRGProductsList_Search: EditText
    private lateinit var BTN_FRGProductsList_AddProduct: Button
    private lateinit var RCV_FRGProductsList_ProductsList: RecyclerView

    private lateinit var adapterProducts: AdapterProducts

    private val productsList = mutableListOf<product>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_products_list,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews(view)
        configureListeners()
        configureRecyclerView()
        loadSampleProducts()
    }

    private fun initializeViews(view: View) {
        IMV_FRGProductsList_ShoppingCart =
            view.findViewById(R.id.IMV_FRGProductsList_ShoppingCart)

        IMV_FRGProductsList_Search =
            view.findViewById(R.id.IMV_FRGProductsList_Search)

        ETX_FRGProductsList_Search =
            view.findViewById(R.id.ETX_FRGProductsList_Search)

        BTN_FRGProductsList_AddProduct =
            view.findViewById(R.id.BTN_FRGProductsList_AddProduct)

        RCV_FRGProductsList_ProductsList =
            view.findViewById(R.id.RCV_FRGProductsList_ProductsList)
    }

    private fun configureListeners() {
        BTN_FRGProductsList_AddProduct.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Añadir producto",
                Toast.LENGTH_SHORT
            ).show()
        }

        IMV_FRGProductsList_ShoppingCart.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Carrito de compras",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun configureRecyclerView() {
        adapterProducts = AdapterProducts(
            productsList = productsList,
            clickOnBuy = { selectedProduct ->
                Toast.makeText(
                    requireContext(),
                    getString(R.string.addCart, selectedProduct.name),
                    Toast.LENGTH_SHORT
                ).show()
            }
        )

        RCV_FRGProductsList_ProductsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterProducts
        }
    }

    private fun loadSampleProducts() {
        val sampleProducts = listOf(
            product(
                id = 1,
                name = "Camisa",
                category = "Ropa de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Camisa de Varón Tommy roja",
                available = true,
                stock = 1
            ),
            product(
                id = 2,
                name = "Pantalón",
                category = "Ropa de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Pantalón de Varón Tommy rojo",
                available = true,
                stock = 1
            ),
            product(
                id = 3,
                name = "Zapatilla",
                category = "Calzado de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Zapatilla de Varón",
                available = true,
                stock = 1
            ),
            product(
                id = 4,
                name = "Zapatos",
                category = "Calzado de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Zapatos de Varón",
                available = true,
                stock = 1
            ),
            product(
                id = 5,
                name = "Corbata",
                category = "Accesorios de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Corbata de Varón",
                available = true,
                stock = 1
            )
        )

        productsList.clear()
        productsList.addAll(sampleProducts)
        adapterProducts.notifyChanged()
    }
}