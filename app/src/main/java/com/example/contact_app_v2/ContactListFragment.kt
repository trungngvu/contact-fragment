package com.example.contact_app_v2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.contact_app_v2.adapter.CustomAdapter

class ContactListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact_list_fragment, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var contactList = view.findViewById<ListView>(R.id.contact_list)
        val items = MainActivity.contacts.map { it }.toMutableList()
        contactList.adapter = CustomAdapter(requireContext(), items)

        contactList.setOnItemClickListener { parent, view, position, id ->
            val item = items[position]
            val params: Bundle = Bundle()
            params.putString("username", item.username)
            params.putString("phone", item.phoneNumber)
            params.putString("email", item.email)
            params.putString("id", item.id.toString())
            view.findNavController().navigate(R.id.action_contact_list_to_contact_detail, params)
        }
    }
}