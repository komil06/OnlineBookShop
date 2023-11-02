package com.example.onlinebookshop

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.onlinebookshop.databinding.FragmentRegisterBinding
import com.example.onlinebookshop.model.User
import com.example.onlinebookshop.model.UserToken
import com.example.onlinebookshop.networking.APIClient
import com.example.onlinebookshop.networking.APIService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = FragmentRegisterBinding.inflate(inflater,container, false)
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_secondFragment)
        }



        val shared = requireContext().getSharedPreferences("shared",AppCompatActivity.MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type


        binding.loginButton.setOnClickListener {
            var users = shared.getString("users"," ")
            var user = User(binding.editTextTextPersonName.text.toString(),binding.editTextTextEmailAddress.text.toString(),binding.password.toString())

            val api = APIClient.getInstance().create(APIService::class.java)
            api.register(user).enqueue(object :retrofit2.Callback<UserToken>{
                override fun onResponse(call: Call<UserToken>, response: Response<UserToken>) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        findNavController().navigate(R.id.boshFragment)
                        shared.edit().putString("active_user", gson.toJson(user)).apply()
                    }, 1500)
                }

                override fun onFailure(call: Call<UserToken>, t: Throwable) {
                    Log.d(TAG, "onFailure: $t")
                }

            })
            findNavController().navigate(R.id.action_registerFragment_to_boshFragment)
        }


        return binding.root
    }


}

