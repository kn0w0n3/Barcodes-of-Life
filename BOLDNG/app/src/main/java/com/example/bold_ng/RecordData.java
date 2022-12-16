package com.example.bold_ng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecordData extends AppCompatActivity {
    DatabaseHelper inputDatabase;
    EditText sampleID, fieldID, museumID, collectionCode, depositIn, phylum, classTxt,
             order, family, subfamily, genus, species, subspecies, binId, vStatus, tDescriptor,
             briefNote, reproduction, sex, lifeStage, detailedNote, country, province_State, region_Country,
             sector, exactSite, latitude, longitude, cordSource, cordAccuracy, dateCollected, collectors, elevation,
             elevAccuracy, depth, depthAccuracy;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_data);
        //etSupportActionBar().hide();
        inputDatabase = new DatabaseHelper(this);

        saveBtn = (Button) findViewById(R.id.rd_SaveBtn);

        sampleID = (EditText) findViewById(R.id.sampleIDEditTxt);
        fieldID = (EditText) findViewById(R.id.fieldIDEditTxt);
        museumID = (EditText) findViewById(R.id.museumIDEditTxt);
        collectionCode = (EditText) findViewById(R.id.collectionCodeEditTxt);
        depositIn = (EditText) findViewById(R.id.depositInEditTxt);
        phylum = (EditText) findViewById(R.id.phylumEditTxt);
        classTxt = (EditText) findViewById(R.id.classEditTxt);

        order = (EditText) findViewById(R.id.orderEditTxt);
        family = (EditText) findViewById(R.id.familyEditTxt);
        subfamily = (EditText) findViewById(R.id.subfamilyEditTxt);
        genus = (EditText) findViewById(R.id.genusEditTxt);
        species = (EditText) findViewById(R.id.speciesEditTxt);
        subspecies = (EditText) findViewById(R.id.subspeciesEditTxt);
        binId = (EditText) findViewById(R.id.binIdEditTxt);

        vStatus = (EditText) findViewById(R.id.voucherStatusEditTxt);
        tDescriptor = (EditText) findViewById(R.id.tissueDescriptorEditTxt);
        briefNote = (EditText) findViewById(R.id.briefNoteEditTxt);
        reproduction = (EditText) findViewById(R.id.reproductionEditTxt);
        sex = (EditText) findViewById(R.id.sexEditTxt);
        lifeStage = (EditText) findViewById(R.id.lifeStageEditTxt);
        detailedNote = (EditText) findViewById(R.id.detailNoteEditTxt);

        country = (EditText) findViewById(R.id.countryEditTxt);
        province_State = (EditText) findViewById(R.id.province_StateEditTxt);
        region_Country = (EditText) findViewById(R.id.region_CountryEditTxt);
        sector = (EditText) findViewById(R.id.sectorEditTxt);
        exactSite = (EditText) findViewById(R.id.exactSiteEditTxt);
        latitude = (EditText) findViewById(R.id.latitudeEditTxt);
        longitude = (EditText) findViewById(R.id.logitudeEditTxt);
        cordSource = (EditText) findViewById(R.id.cordSourceEditTxt);
        cordAccuracy = (EditText) findViewById(R.id.cordAccuracyEditTxt);
        dateCollected = (EditText) findViewById(R.id.dateCollectedEditTxt);
        collectors = (EditText) findViewById(R.id.collectorsEditTxt);
        elevation = (EditText) findViewById(R.id.elevationEditTxt);
        elevAccuracy = (EditText) findViewById(R.id.elevAccuracyEditTxt);
        depth = (EditText) findViewById(R.id.depthEditTxt);
        depthAccuracy = (EditText) findViewById(R.id.depthAccuracyEditTxt);

        AddData();
    }

    public void AddData(){
        saveBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       boolean isInserted =  inputDatabase.insertData(sampleID.getText().toString(), fieldID.getText().toString(),
                               museumID.getText().toString(), collectionCode.getText().toString() , depositIn.getText().toString(),
                               phylum.getText().toString(), classTxt.getText().toString(), order.getText().toString(), family.getText().toString(),
                               subfamily.getText().toString(), genus.getText().toString(), species.getText().toString(), subspecies.getText().toString(),
                               binId.getText().toString(), vStatus.getText().toString(), tDescriptor.getText().toString(),  briefNote.getText().toString(),
                               reproduction.getText().toString(), sex.getText().toString(), lifeStage.getText().toString(), detailedNote.getText().toString(),
                               country.getText().toString(), province_State.getText().toString(), region_Country.getText().toString(), sector.getText().toString(),
                               exactSite.getText().toString(), latitude.getText().toString(), longitude.getText().toString(), cordSource.getText().toString(),
                               cordAccuracy.getText().toString(), dateCollected.getText().toString(), collectors.getText().toString(), elevation.getText().toString(),
                               elevAccuracy.getText().toString(), depth.getText().toString(), depthAccuracy.getText().toString());

                       if(isInserted == true){
                           Toast.makeText(RecordData.this, "Data Inserted", Toast.LENGTH_LONG).show();
                       }
                       else{
                           Toast.makeText(RecordData.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                       }
                    }
                }
        );
    }
}