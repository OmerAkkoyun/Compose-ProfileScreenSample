package com.omerakkoyun.profilescreencompose.dummy

import com.omerakkoyun.profilescreencompose.R
import com.omerakkoyun.profilescreencompose.model.ItemModel

/**
 * Created by Omer AKKOYUN on 23.09.2024.
 */
class DummyHelper {

    companion object {
        fun getItems(): ArrayList<ItemModel> {
            val list = ArrayList<ItemModel>()
            list.add(ItemModel("Notifications", R.drawable.btn_1))
            list.add(ItemModel("Calendar", R.drawable.btn_2))
            list.add(ItemModel("Gallery", R.drawable.btn_3))
            list.add(ItemModel("My Playlist", R.drawable.btn_4))
            list.add(ItemModel("Share", R.drawable.btn_5))
            list.add(ItemModel("Log Out", R.drawable.btn_6))
            return list
        }
    }
}