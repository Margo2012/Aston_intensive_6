package com.example.phonecontacts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phonecontacts.R
import com.example.phonecontacts.adapters.PersonAdapter
import com.example.phonecontacts.models.Person
import com.example.phonecontacts.utils.createContacts

private const val FRAGMENT_DETAIL_TAG = "DETAIL_TAG"
private const val BACKSTACK_TAG = "backstack tag"

class ContactsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listPerson = createContacts()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)

        recyclerView.adapter = PersonAdapter(listPerson) { person ->
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                val fragment = ContactsDetailFragment.newInstance(person)
                replace(R.id.fragment_container, fragment, FRAGMENT_DETAIL_TAG)
                addToBackStack(BACKSTACK_TAG)
                commit()
            }
        }
    }

    companion object {
        private const val PERSON_ARG = "name"
        fun newInstance(person: Person) = ContactsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(PERSON_ARG, person)
            }
        }
    }

}