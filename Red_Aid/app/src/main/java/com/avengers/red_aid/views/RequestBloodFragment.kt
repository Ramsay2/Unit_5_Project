package com.avengers.red_aid.views

import android.Manifest
import android.content.ContentResolver
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.avengers.red_aid.R
import com.avengers.red_aid.databinding.FragmentRequestBloodBinding
import kotlinx.android.synthetic.main.fragment_request_blood.*
import java.io.FileNotFoundException
import java.io.InputStream


class RequestBloodFragment : Fragment() {
    private lateinit var requestBloodBinding: FragmentRequestBloodBinding
    private var imagePath: String? = null

    private val launchGallery : ActivityResultLauncher<Intent> = registerForActivityResult(
             ActivityResultContracts.StartActivityForResult(), ActivityResultCallback<ActivityResult>() {
                @Override
                fun onActivityResult(result:ActivityResult) {

                    if (result.data != null) {
                        val selectedImageUri : Uri = result.data!!.data!!
                        try {
                            getImagePathFromUri(selectedImageUri)

                            requestBloodBinding.etUploadPrescription.setText("imagePath" )

                        } catch (e: FileNotFoundException) {
                            e.printStackTrace();
                        }

                    }
                }
            }
    );


    private fun getImagePathFromUri(selectedImage: Uri): Cursor {
        val filePath = arrayOf(MediaStore.Images.Media.DATA)
        val c: Cursor = requireActivity().contentResolver.query(
            selectedImage, filePath,
            null, null, null)!!
        c.moveToFirst()
        val columnIndex = c.getColumnIndex(filePath[0])
        Toast.makeText(context, "$imagePath", Toast.LENGTH_SHORT).show()
        imagePath = c.getString(columnIndex)
        return c
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requestBloodBinding = FragmentRequestBloodBinding.inflate(layoutInflater)
        return requestBloodBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color()
        bloodGroup(view)

        val navController = Navigation.findNavController(view)

       requestBloodBinding.btnCheck.setOnClickListener {
            navController.navigate(R.id.action_requestBloodFragment_to_bloodrequestFragment)
        }


        requestBloodBinding.apply {
            etAddress.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {}

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                    if (s.isNotEmpty()) {
                        btnCheck.isClickable = true
                        btnCheck.setBackgroundColor(btnCheck.resources.getColor(R.color.red_aid_red_700))
                    } else {
                        btnCheck.isClickable = false
                        btnCheck.setBackgroundColor(btnCheck.resources.getColor(R.color.red_aid_red_200))
                    }
                }
            })

            etUploadPrescription.setOnClickListener {
                if (isPermissionGranted()) {
                    openGallery()
                } else {
                    ActivityCompat.requestPermissions(
                        requireActivity(),
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        1
                    )
                }
            }

        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        launchGallery.launch(intent)
    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun bloodGroup(view: View) {
        val group = view.resources.getStringArray(R.array.BloodGroup)
        val arrayAdapter = context?.let {
            ArrayAdapter(it, R.layout.dropdown_layout, group)
        }
        val autocompleteTV = view.findViewById<AutoCompleteTextView>(R.id.etBloodGroup)
        autocompleteTV?.setAdapter(arrayAdapter)
    }

    private fun color() {
        var blood = 1
        var plasma = 1
        var platelets = 1
        btnBlood.setOnClickListener {
            blood = if (blood == 1) {
                btnBlood.setBackgroundColor(resources.getColor(R.color.red_aid_green_500))
                0
            } else {
                btnBlood.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
                1
            }

            btnPlasma.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
            btnPlatelets.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
        }
        btnPlasma.setOnClickListener {
            plasma = if (plasma == 1) {
                btnPlasma.setBackgroundColor(resources.getColor(R.color.red_aid_green_500))
                0
            } else {
                btnPlasma.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
                1
            }

            btnBlood.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
            btnPlatelets.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
        }
        btnPlatelets.setOnClickListener {
            platelets = if (platelets == 1) {
                btnPlatelets.setBackgroundColor(resources.getColor(R.color.red_aid_green_500))
                0
            } else {
                btnPlatelets.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
                1
            }

            btnBlood.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
            btnPlasma.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
        }


    }

}