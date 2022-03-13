package com.example.aroma.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aroma.R;
import com.example.aroma.models.FarmerRegistrationForm;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FarmerRegistration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FarmerRegistration extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText name,father_name,phone, email,aadhaar,family_count,address;
    EditText total_land_area, total_annual_income_Agri,annual_income_Crop, map_cultivation_dur, requirement ,requirement_qnty, received,received_qnty;
    EditText other_machinery,other_fld_condition,other_aroma_msn_A,other_aroma_msn_N, maxProfit;
    TextView tvDateOfBirth;
    ImageView ivDob;
    DatePickerDialog.OnDateSetListener setListener;
    CheckBox male, female;
    CheckBox married, unmarried, electricity_yes, electricity_no;
    CheckBox  tractor, harvester, rotavator,tubewell_m, machine_none;
    CheckBox irrigated, non_irrigated,wasteland, droughtAff,waterlogged;
    CheckBox ir_tubewell,ir_pond,ir_canal,ir_well,ir_rainfed;
    Button submitButten;

    // Do you want to cultivate (marked as name_N)...

    CheckBox lavender_N,lemongrass_N,ocimum_N,rosegrass_N,rosemarry_N,mentha_N,salvia_sclarec_N,garanium_N,jammu_monarda_N;

    //Are you Cultivating aromatic Crops(marked as name_A)...

    CheckBox lavender_A,lemongrass_A,ocimum_A,rosegrass_A,rosemarry_A,mentha_A,salvia_sclarec_A,garanium_A,jammu_monarda_A;

    //Do you want Agro_Advisory
    CheckBox aa_yes, aa_no;

    //Beneficiary of CSiR-IIIM through
    CheckBox planting_materials, adv_service,traning_prog, rural_dev,kisan_mela,field_demo,distillation_unit,herbal_product,other_ben;

    //sell essential oils
    CheckBox sell_yes, sell_no;
    //Acknowledgement...
    CheckBox acc_yes;

    Spinner education, occupation, category, state;




    public FarmerRegistration() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FarmerRegistration.
     */
    // TODO: Rename and change types and number of parameters
    public static FarmerRegistration newInstance(String param1, String param2) {
        FarmerRegistration fragment = new FarmerRegistration();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_farmer_registration, container, false);
        name = v.findViewById(R.id.idETName);
        father_name= v.findViewById(R.id.idETFName);
        phone =v. findViewById(R.id.idETPhone);
        email=v. findViewById(R.id.idETMail);
        aadhaar =v. findViewById(R.id.idETAadhaar);
         tvDateOfBirth =v.findViewById(R.id.iddob);
         ivDob = v.findViewById(R.id.ivGetDob);
        //Spinners
        education = v.findViewById(R.id.idSEducation);
        occupation = v.findViewById(R.id.idSOccupation);
        category = v.findViewById(R.id.idSCategory);
        family_count = v.findViewById(R.id.idETFamilyCount);
        // spinner state
        state = v.findViewById(R.id.idSState);
        address = v.findViewById(R.id.idETPAddress);
        other_machinery = v.findViewById(R.id.idETMachineryOther);
        total_land_area = v.findViewById(R.id.idETTotalLandArea);
        total_annual_income_Agri = v.findViewById(R.id.idETTotalAgriIncome);
        annual_income_Crop = v.findViewById(R.id.idETTotalCropIncome);
        other_fld_condition = v.findViewById(R.id.idETFieldConditionOther);
        other_aroma_msn_A = v.findViewById(R.id.idETAroMissionOtherA);
        other_aroma_msn_N = v.findViewById(R.id.idETAroMissionOtherN);
        map_cultivation_dur = v.findViewById(R.id.idMAPCultivation);
        requirement = v.findViewById(R.id.idETPMRequirementSelp);
        requirement_qnty = v.findViewById(R.id.idETPMRequirementkgs);
        received = v.findViewById(R.id.idETPMReceivedSelp);
        received_qnty = v.findViewById(R.id.idETPMReceivedKgs);

        male =v.findViewById(R.id.idCBGenderM);
        female =v.findViewById(R.id.idCBGenderF);
        married=v.findViewById(R.id.idCBMarried);
        unmarried=v.findViewById(R.id.idCBUnMarried);
        electricity_yes=v.findViewById(R.id.idCBElectricityYes);
        electricity_no=v.findViewById(R.id.idCBElectricityNo);
        tractor=v.findViewById(R.id.idCBSTractor);
        harvester=v.findViewById(R.id.idCBHarvester);
        rotavator=v.findViewById(R.id.idCBRotavator);
        tubewell_m=v.findViewById(R.id.idCBTubewellM);
        machine_none=v.findViewById(R.id.idCBMachine_none);
        irrigated=v.findViewById(R.id.idCBSIrrigated);
        non_irrigated=v.findViewById(R.id.idCBNonIrrigated);
        wasteland=v.findViewById(R.id.idCBWasteland);
        droughtAff=v.findViewById(R.id.idCBDroughtAffect);
        waterlogged=v.findViewById(R.id.idCBWaterlogged);
        ir_tubewell =v.findViewById(R.id.idCBTubewellI);
        ir_pond =v.findViewById(R.id.idCBPond);
        ir_canal =v.findViewById(R.id.idCBCanal);
        ir_well =v.findViewById(R.id.idCBWell);
        ir_rainfed =v.findViewById(R.id.idCBRainfed);


        // Do you want to cultivate (marked as name_N)...
        lavender_N =v.findViewById(R.id.idCBLavenderN);
        lemongrass_N =v.findViewById(R.id.idCBLemongrassN);
        ocimum_N =v.findViewById(R.id.idCBOcimumN);
        rosegrass_N =v.findViewById(R.id.idCBRosegrassN);
        rosemarry_N =v.findViewById(R.id.idCBRosemaryN);
        mentha_N =v.findViewById(R.id.idCBMenthaN);
        salvia_sclarec_N =v.findViewById(R.id.idCBSalviaN);
        garanium_N =v.findViewById(R.id.idCBGaraniumN);
        jammu_monarda_N =v.findViewById(R.id.idCBJammuMonardaN);


        //Are you Cultivating aromatic Crops(marked as name_A)...
        lavender_A =v.findViewById(R.id.idCBLavenderA);
        lemongrass_A =v.findViewById(R.id.idCBLemongrassA);
        ocimum_A =v.findViewById(R.id.idCBOcimumA);
        rosegrass_A =v.findViewById(R.id.idCBRosagrassA);
        rosemarry_A =v.findViewById(R.id.idCBRosemaryA);
        mentha_A =v.findViewById(R.id.idCBMenthaA);
        salvia_sclarec_A =v.findViewById(R.id.idCBSalviaA);
        garanium_A =v.findViewById(R.id.idCBGaraniumA);
        jammu_monarda_A =v.findViewById(R.id.idCBJammuMonardaA);

        // Hoe long involved in MAP's Cultivation
        map_cultivation_dur = v.findViewById(R.id.idMAPCultivation);

        //Aromatic crop privide Maximum Profit
        maxProfit = v.findViewById(R.id.idETMaxProfit);

        //Do you want Agro_Advisory
        aa_yes =v.findViewById(R.id.idCBEAgroAdvisoryYes);
        aa_no =v.findViewById(R.id.idCBAgroAdvisoryNo);


        //Beneficiary of CSiR-IIIM through
        planting_materials =v.findViewById(R.id.idCBPlantingMaterial);
        adv_service =v.findViewById(R.id.idCBAdvisoryServices);
        traning_prog =v.findViewById(R.id.idCBTrainningprogram);
        rural_dev =v.findViewById(R.id.idCBRuralDev);
        kisan_mela =v.findViewById(R.id.idCBIIIMKMela);
        field_demo =v.findViewById(R.id.idCBFieldDemostration);
        distillation_unit =v.findViewById(R.id.idCBDistillationUnit);
        herbal_product =v.findViewById(R.id.idCBHerbalProduct);
        other_ben =v.findViewById(R.id.idCBCsirThroughOther);


        //sell essential oils
        sell_yes =v.findViewById(R.id.idCBSellEssentialsYes);
        sell_no =v.findViewById(R.id.idCBSellEssentialsNo);

        //Acknowledgement...
        acc_yes =v.findViewById(R.id.idCBAcknowledge);

        submitButten = v.findViewById(R.id.idBtnSubmit);


        return  v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submitButten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    getRegistrationForm();
                    Toast.makeText(getContext(),"Form Submitted",Toast.LENGTH_LONG).show();


                }
            }
        });

        setListeners();
    }

    void  setListeners()
    {
        unmarried.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    married.setChecked(false);
                }
            }
        });


        married.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    unmarried.setChecked(false);
                }
            }
        });

        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    female.setChecked(false);
                }
            }
        });


        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    male.setChecked(false);
                }
            }
        });
        ivDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year =calendar.get(Calendar.YEAR);
                int month =calendar.get(Calendar.MONTH);
                int day =calendar.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), android.R.style.Theme_Material_Dialog,setListener, year,month,day);
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month= month+1;
                String  birthDate= dayOfMonth + "/"+ month+"/"+year;
                tvDateOfBirth.setText(birthDate);

            }
        };




        electricity_yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    electricity_no.setChecked(false);
                }
            }
        });


        electricity_no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    electricity_yes.setChecked(false);
                }
            }
        });
        aa_yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    aa_no.setChecked(false);
                }
            }
        });


        aa_no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    aa_yes.setChecked(false);
                }
            }
        });

        sell_yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    sell_no.setChecked(false);
                }
            }
        });


        sell_no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    sell_yes.setChecked(false);
                }
            }
        });
        tractor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    machine_none.setChecked(false);
                }
            }
        });
        harvester.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    machine_none.setChecked(false);
                }
            }
        });
        rotavator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    machine_none.setChecked(false);
                }
            }
        });
        tubewell_m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    machine_none.setChecked(false);
                }
            }
        });
        machine_none.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    tractor.setChecked(false);
                    harvester.setChecked(false);
                    rotavator.setChecked(false);
                    tubewell_m.setChecked(false);
                    other_machinery.setEnabled(false);


                }else {
                    other_machinery.setEnabled(true);
                }

            }
        });






     String b=  (String) education.getItemAtPosition(0);
        Log.d("EDU",": "+b);




    }

    boolean validate(){
        boolean result=true;

        if(name.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.enter_name),Toast.LENGTH_LONG).show();
            name.requestFocus();
            return  false;
        }

        if(father_name.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.f_name),Toast.LENGTH_LONG).show();
            father_name.requestFocus();
            return  false;

        }

        if(phone.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.phone_number),Toast.LENGTH_LONG).show();
            phone.requestFocus();
            return  false;

        }

        if(email.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.email),Toast.LENGTH_LONG).show();
            email.requestFocus();
            return  false;

        }

        if(aadhaar.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.aadhar),Toast.LENGTH_LONG).show();
            aadhaar.requestFocus();
            return  false;

        }
        if(aadhaar.getText().toString().length()!=12)
        {
            Toast.makeText(getContext(),"Enter Valid Adhaar number",Toast.LENGTH_LONG).show();
            aadhaar.requestFocus();
            return  false;

        }

        if(male.isChecked()== false && female.isChecked()== false){
           Toast.makeText(getContext(),"Select gender",Toast.LENGTH_LONG).show();
            return  false;

        }

        if(tvDateOfBirth.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),"Select Date Of Birth",Toast.LENGTH_LONG).show();
            tvDateOfBirth.requestFocus();
            return  false;

        }
        if(married.isChecked()== false && unmarried.isChecked()== false){
            Toast.makeText(getContext(),"Select marital Status",Toast.LENGTH_LONG).show();
            return  false;

        }



        String ed=(String) education.getItemAtPosition(Integer.parseInt(""+education.getSelectedItemId()));
        String e1=getActivity().getResources().getStringArray(R.array.Education)[0];

        if(ed.equals(e1))
        {
           Toast.makeText(getContext(),"Select Education",Toast.LENGTH_LONG).show();

            return false;

        }
        String occ=(String) occupation.getItemAtPosition(Integer.parseInt(""+occupation.getSelectedItemId()));
        String occ1=getActivity().getResources().getStringArray(R.array.Occupation)[0];

        if(occ.equals(occ1))
        {
            Toast.makeText(getContext(),"Select Occupation",Toast.LENGTH_LONG).show();
            return false;

        }
        String cat=(String) category.getItemAtPosition(Integer.parseInt(""+category.getSelectedItemId()));
        String cat1=getActivity().getResources().getStringArray(R.array.Category)[0];

        if(cat.equals(cat1))
        {
            Toast.makeText(getContext(),"Select Category",Toast.LENGTH_LONG).show();
            return false;

        }
        if(family_count.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.family_count),Toast.LENGTH_LONG).show();

            return  false;

        }
        String st=(String) state.getItemAtPosition(Integer.parseInt(""+state.getSelectedItemId()));
        String st1=getActivity().getResources().getStringArray(R.array.india_states)[0];

        if(st.equals(st1))
        {
            Toast.makeText(getContext(),"Select State",Toast.LENGTH_LONG).show();
            return false;

        }


        if(address.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.c_address),Toast.LENGTH_LONG).show();

            return  false;

        }

        if(electricity_yes.isChecked()== false && electricity_no.isChecked()== false){

            Toast.makeText(getContext(),"IsbElectricity Available",Toast.LENGTH_LONG).show();
            return  false;

        }
        if(tractor.isChecked()== false && harvester.isChecked()== false &&rotavator.isChecked()== false && tubewell_m.isChecked()== false && machine_none.isChecked()==false && other_machinery.getText().toString().isEmpty()) {


            Toast.makeText(getContext(),"Select  Farm Machinery",Toast.LENGTH_LONG).show();
            return  false;

        }
        if(total_land_area.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.t_land_area),Toast.LENGTH_LONG).show();

            return  false;

        }
        if(total_annual_income_Agri.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.t_annual_income),Toast.LENGTH_LONG).show();

            return  false;

        }
        if(annual_income_Crop.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),getString(R.string.aromatic_crops),Toast.LENGTH_LONG).show();

            return  false;

        }
        if(acc_yes.isChecked()==false){

            Toast.makeText(getContext(),"Accept the Acknowledgement ",Toast.LENGTH_LONG).show();

            return  false;

        }






        return  result;

    }


    FarmerRegistrationForm getRegistrationForm()
    {
        FarmerRegistrationForm farmerRegistration=new FarmerRegistrationForm();
        farmerRegistration.setName(name.getText().toString());
        farmerRegistration.setfName(father_name.getText().toString());
        farmerRegistration.setPhoneNumber(phone.getText().toString());
        farmerRegistration.setEmail(email.getText().toString());
        farmerRegistration.setAdhaarNo(aadhaar.getText().toString());

        if(male.isChecked()){
            farmerRegistration.setGender(true);
        }else{
            farmerRegistration.setGender(false);
        }
       // set dateOfBirth here
        farmerRegistration.setDateOfBirth(tvDateOfBirth.getText().toString());






       // farmerRegistration.setDateOfBirth(dayOfMonth + "/"+ month+"/"+year);


        if(married.isChecked()){
            farmerRegistration.setGender(true);
        }else{
            farmerRegistration.setGender(false);
        }

        farmerRegistration.setEducation((String) education.getItemAtPosition(Integer.parseInt(""+education.getSelectedItemId())));
        farmerRegistration.setOccupation((String) occupation.getItemAtPosition(Integer.parseInt(""+occupation.getSelectedItemId())));
        farmerRegistration.setCategory((String) category.getItemAtPosition(Integer.parseInt(""+category.getSelectedItemId())));


        farmerRegistration.setFamilyCount(family_count.getText().toString());

        farmerRegistration.setState((String) state.getItemAtPosition(Integer.parseInt(""+state.getSelectedItemId())));

        farmerRegistration.setAddress(address.getText().toString());

        if(electricity_yes.isChecked()){
            farmerRegistration.setEleAvailable(true);
        }else {
            farmerRegistration.setEleAvailable(false);
        }


        //-----------------------------------------------


         if(tractor.isChecked())
         {
             farmerRegistration.getFarmMachinery().add("Tractor");
         }

         if(harvester.isChecked())
         {
             farmerRegistration.getFarmMachinery().add("Harvester");
         }

         if(rotavator.isChecked())
         {
             farmerRegistration.getFarmMachinery().add("Rotavator");

         }
        if(tubewell_m.isChecked())
        {
           farmerRegistration.getFarmMachinery().add("Tubewell");

        }
       //set  other_machinery value here
       if(!other_machinery.getText().toString().isEmpty()){

          farmerRegistration.getFarmMachinery().add(other_machinery.getText().toString());

       }




        farmerRegistration.setTotalLandArea(total_land_area.getText().toString());
        farmerRegistration.setTotalAnnualIncomeAgr(total_annual_income_Agri.getText().toString());
        farmerRegistration.setAnnualIncomeAro(annual_income_Crop.getText().toString());
        if(irrigated.isChecked())
        {
            farmerRegistration.getFieldCondition().add("Irrigated");

        }
        if(non_irrigated.isChecked())
        {
            farmerRegistration.getFieldCondition().add("Non irrigated/rainfed");

        }
        if(wasteland.isChecked())
        {
            farmerRegistration.getFieldCondition().add("Wasteland");

        }
        if(droughtAff.isChecked())
        {
            farmerRegistration.getFieldCondition().add("Drought Affected");

        }
        if(waterlogged.isChecked())
        {
            farmerRegistration.getFieldCondition().add("Waterlogged");

        }
        // set other_fld_condition value here
        if(!other_fld_condition.getText().toString().isEmpty()){

            farmerRegistration.getFieldCondition().add(other_fld_condition.getText().toString());

        }


        //Irrigation Facility
        if(ir_tubewell.isChecked()){

            farmerRegistration.getIrrigationFacility().add("Tubewell");
        }
        if(ir_pond.isChecked()){

            farmerRegistration.getIrrigationFacility().add("Pond");
        }
        if(ir_canal.isChecked()){

            farmerRegistration.getIrrigationFacility().add("Canal");
        }
        if(ir_well.isChecked()){

            farmerRegistration.getIrrigationFacility().add("Well");
        }
        if(ir_rainfed.isChecked()){

            farmerRegistration.getIrrigationFacility().add("Rainfed");
        }


        //Do you want to Cultivate aromatic crops....then mention?
        if(lavender_N.isChecked()){

            farmerRegistration.getWantCulAc().add("Lavender");
        }
        if(rosegrass_N.isChecked()){

            farmerRegistration.getWantCulAc().add("Rosegrass");
        }
        if(salvia_sclarec_N.isChecked()){

            farmerRegistration.getWantCulAc().add("Salvia Sclarec");
        }
        if(lemongrass_N.isChecked()){

            farmerRegistration.getWantCulAc().add("lemongrass");
        }
        if(rosemarry_N.isChecked()){

            farmerRegistration.getWantCulAc().add("Rosemary");
        }
        if(garanium_N.isChecked()){

            farmerRegistration.getWantCulAc().add("Garanium");
        }
        if(ocimum_N.isChecked()){

            farmerRegistration.getWantCulAc().add("Ocimum");
        }
        if(mentha_N.isChecked()){

            farmerRegistration.getWantCulAc().add("Mentha");
        }
        if(jammu_monarda_N.isChecked()){

            farmerRegistration.getWantCulAc().add("Jammu Monarda");
        }
        // set other_aroma_msn_N value here
        if(!other_aroma_msn_N.getText().toString().isEmpty()){

            farmerRegistration.getWantCulAc().add(other_aroma_msn_N.getText().toString());

        }


        if(lavender_A.isChecked()){

            farmerRegistration.getCultAc().add("Lavender");
        }
        if(rosegrass_A.isChecked()){

            farmerRegistration.getCultAc().add("Rosegrass");
        }
        if(salvia_sclarec_A.isChecked()){

            farmerRegistration.getCultAc().add("Salvia Sclarec");
        }
        if(lemongrass_A.isChecked()){

            farmerRegistration.getCultAc().add("lemongrass");
        }
        if(rosemarry_A.isChecked()){

            farmerRegistration.getCultAc().add("Rosemary");
        }
        if(garanium_A.isChecked()){

            farmerRegistration.getCultAc().add("Garanium");
        }
        if(ocimum_A.isChecked()){

            farmerRegistration.getCultAc().add("Ocimum");
        }
        if(mentha_A.isChecked()){

            farmerRegistration.getCultAc().add("Mentha");
        }
        if(jammu_monarda_A.isChecked()){

            farmerRegistration.getCultAc().add("Jammu Monarda");
        }

       // set value here other_aroma_msn_A

        if(!other_aroma_msn_A.getText().toString().isEmpty()){

            farmerRegistration.getCultAc().add(other_aroma_msn_A.getText().toString());

        }

        farmerRegistration.setDurationMAPsCul(map_cultivation_dur.getText().toString());
        farmerRegistration.setAcMaxProfit(maxProfit.getText().toString());
        if(aa_yes.isChecked()){
            farmerRegistration.setDoUWantAgroAdv(true);
        }else {
            farmerRegistration.setDoUWantAgroAdv(false);
        }

        farmerRegistration.setReqSlips(requirement.getText().toString());
        farmerRegistration.setReqKgs(requirement_qnty.getText().toString());

        farmerRegistration.setRecSlips(received.getText().toString());
        farmerRegistration.setRecKgs(received_qnty.getText().toString());


        return farmerRegistration;
    }

}