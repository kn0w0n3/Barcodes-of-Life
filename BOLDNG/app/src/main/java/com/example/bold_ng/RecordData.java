package com.example.bold_ng;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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
    Button viewAllBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_data);
        //etSupportActionBar().hide();
        inputDatabase = new DatabaseHelper(this);

        saveBtn = (Button) findViewById(R.id.rd_SaveBtn);
        viewAllBtn = (Button) findViewById(R.id.viewDataBtn);

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
        viewAll();
    }
    //Insert Data
    public void AddData(){
        saveBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       boolean isInserted =  inputDatabase.insertData(sampleID.getText().toString(), fieldID.getText().toString(),museumID.getText().toString(),
                               collectionCode.getText().toString(), depositIn.getText().toString(), phylum.getText().toString(), subfamily.getText().toString(),
                               classTxt.getText().toString(), order.getText().toString(), family.getText().toString(), genus.getText().toString(),
                               species.getText().toString(), subspecies.getText().toString(), binId.getText().toString(), vStatus.getText().toString(),
                               tDescriptor.getText().toString(), briefNote.getText().toString(),reproduction.getText().toString(), sex.getText().toString(),
                               lifeStage.getText().toString(), detailedNote.getText().toString(), country.getText().toString(), province_State.getText().toString(),
                               region_Country.getText().toString(), sector.getText().toString(), exactSite.getText().toString(), latitude.getText().toString(),
                               longitude.getText().toString(), cordSource.getText().toString(), cordAccuracy.getText().toString(), dateCollected.getText().toString(),
                               collectors.getText().toString(), elevation.getText().toString(), elevAccuracy.getText().toString(), depth.getText().toString(),
                               depthAccuracy.getText().toString());

                       if(isInserted){
                           Toast.makeText(RecordData.this, "Data Inserted", Toast.LENGTH_LONG).show();
                       }
                       else{
                           Toast.makeText(RecordData.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                       }
                    }
                }
        );
    }

    //Get and view data
    public void viewAll(){
        viewAllBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = inputDatabase.getAllData();
                        if(res.getCount() == 0){
                            //Show message
                            showMessage("Error", "No data to display");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("id: " + res.getString(0) + "\n"); buffer.append("Sample ID: " + res.getString(1) + "\n");
                            buffer.append("Field ID: " + res.getString(2) + "\n"); buffer.append("Museum ID: " + res.getString(3) + "\n");
                            buffer.append("Collection Code: " + res.getString(4) + "\n"); buffer.append("Deposited In: " + res.getString(5) + "\n");
                            buffer.append("Phylum: " + res.getString(6) + "\n"); buffer.append("Class: " + res.getString(7) + "\n");
                            buffer.append("Order: " + res.getString(8) + "\n"); buffer.append("Family: " + res.getString(9) + "\n");
                            buffer.append("Subfamily: " + res.getString(10) + "\n"); buffer.append("Genus: " + res.getString(11) + "\n");
                            buffer.append("Species: " + res.getString(12) + "\n"); buffer.append("Subspecies: " + res.getString(13) + "\n");
                            buffer.append("Bin ID: " + res.getString(14) + "\n"); buffer.append("Voucher Status: " + res.getString(15) + "\n");
                            buffer.append("Tissue Descriptor: " + res.getString(16) + "\n"); buffer.append("Brief Note: " + res.getString(17) + "\n");
                            buffer.append("Reproduction: " + res.getString(18) + "\n"); buffer.append("Sex: " + res.getString(19) + "\n");
                            buffer.append("Life Stage: " + res.getString(20) + "\n"); buffer.append("Detailed Note: " + res.getString(21) + "\n");
                            buffer.append("Country: " + res.getString(22) + "\n"); buffer.append("Province/State: " + res.getString(23) + "\n");
                            buffer.append("Sector: " + res.getString(24) + "\n"); buffer.append("Exact Site: " + res.getString(25) + "\n");
                            buffer.append("Latitude: " + res.getString(26) + "\n"); buffer.append("Longitude: " + res.getString(27) + "\n");
                            buffer.append("Coord Source: " + res.getString(28) + "\n"); buffer.append("Coord Accuracy: " + res.getString(29) + "\n");
                            buffer.append("Date Collected: " + res.getString(30) + "\n"); buffer.append("Collectors: " + res.getString(31) + "\n");
                            buffer.append("Elevation: " + res.getString(32) + "\n"); buffer.append("Elev Accuracy: " + res.getString(33) + "\n");
                            buffer.append("Depth: " + res.getString(34) + "\n"); buffer.append("Depth Accuracy: " + res.getString(35) + "\n\n");
                        }
                        //Show all Data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    //Show database contents
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}