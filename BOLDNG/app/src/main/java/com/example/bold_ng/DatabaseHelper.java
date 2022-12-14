package com.example.bold_ng;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "specimen_data.db";
    public final static String TABLE_NAME = "user_input_table";

    //Column ID
    public final static String COL_1 = "id";

    //BOLD Identifiers info
    public final static String COL_2 = "i_sample_id";
    public final static String COL_3 = "i_field_id";
    public final static String COL_4 = "i_museum_id";
    public final static String COL_5 = "i_collection_code";
    public final static String COL_6 = "i_deposited_in";

    //BOLD Taxonomy info
    public final static String COL_7 = "t_phylum";
    public final static String COL_8 = "t_class";
    public final static String COL_9 = "t_order";
    public final static String COL_10 = "t_family";
    public final static String COL_11 = "t_subfamily";
    public final static String COL_12 = "t_genus";
    public final static String COL_13 = "t_species";
    public final static String COL_14 = "t_subspecies";
    public final static String COL_15 = "t_bin_id";

    //Bold Specimen Details
    public final static String COL_16 = "s_voucher_status";
    public final static String COL_17 = "s_tissue_descriptor";
    public final static String COL_18 = "s_brief_note";
    public final static String COL_19 = "s_reproduction";
    public final static String COL_20 = "s_sex";
    public final static String COL_21 = "s_life_stage";
    public final static String COL_22 = "s_detailed_note";

    //BOLD Collection Details
    public final static String COL_23 = "c_country";
    public final static String COL_24 = "c_province_state";
    public final static String COL_25 = "c_region_country";
    public final static String COL_26 = "c_sector";
    public final static String COL_27 = "c_exact_site";
    public final static String COL_28 = "c_latitude";
    public final static String COL_29 = "c_longitude";
    public final static String COL_30 = "c_cord_source";
    public final static String COL_31 = "c_cord_accuracy";
    public final static String COL_32 = "c_date_collected";
    public final static String COL_33 = "c_collectors";
    public final static String COL_34 = "c_elevation";
    public final static String COL_35 = "c_elv_accuracy";
    public final static String COL_36 = "c_depth";
    public final static String COL_37 = "c_depth_accuracy";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME +" (id INTEGER PRIMARY KEY AUTOINCREMENT, i_sample_id TEXT, i_field_id TEXT, i_museum_id TEXT, i_collection_code TEXT," +
                "i_deposited_in TEXT, t_phylum TEXT, t_class TEXT, t_order TEXT, t_family TEXT, t_subfamily TEXT, t_genus TEXT, t_species TEXT, t_subspecies TEXT, t_bin_id TEXT, s_voucher_status TEXT, s_tissue_descriptor TEXT," +
                " s_brief_note TEXT, s_reproduction TEXT, s_sex TEXT, s_life_stage TEXT, s_detailed_note TEXT, c_country TEXT, c_province_state TEXT, c_region_country TEXT, c_sector TEXT, c_exact_site TEXT, c_latitude TEXT," +
                "c_longitude TEXT, c_cord_source TEXT, c_cord_accuracy TEXT, c_date_collected TEXT, c_collectors TEXT, c_elevation TEXT, c_elv_accuracy TEXT, c_depth TEXT, c_depth_accuracy TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String i_sample_id, String i_field_id, String i_museum_id, String i_collection_code, String i_deposited_in, String t_phylum, String t_class,
                              String t_order, String t_family, String t_subfamily, String t_genus, String t_species, String t_subspecies, String t_bin_id, String s_voucher_status,
                              String s_tissue_descriptor, String s_brief_note, String s_reproduction, String s_sex, String s_life_stage, String s_detailed_note, String c_country,
                              String c_province_state, String c_region_country, String c_sector, String c_exact_site, String c_latitude, String c_longitude, String c_cord_source,
                              String c_cord_accuracy, String c_date_collected, String c_collectors, String c_elevation, String c_elv_accuracy, String c_depth, String c_depth_accuracy){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, i_sample_id);
        contentValues.put(COL_3, i_field_id);
        contentValues.put(COL_4, i_museum_id);
        contentValues.put(COL_5, i_collection_code);
        contentValues.put(COL_6, i_deposited_in);
        contentValues.put(COL_7, t_phylum);
        contentValues.put(COL_8, t_class);
        contentValues.put(COL_9, t_order);
        contentValues.put(COL_10, t_family);
        contentValues.put(COL_11, t_subfamily);
        contentValues.put(COL_12, t_genus);
        contentValues.put(COL_13, t_species);
        contentValues.put(COL_14, t_subspecies);
        contentValues.put(COL_15, t_bin_id);
        contentValues.put(COL_16, s_voucher_status);
        contentValues.put(COL_17, s_tissue_descriptor);
        contentValues.put(COL_18, s_brief_note);
        contentValues.put(COL_19, s_reproduction);
        contentValues.put(COL_20, s_sex);
        contentValues.put(COL_21, s_life_stage);
        contentValues.put(COL_22, s_detailed_note);
        contentValues.put(COL_23, c_country);
        contentValues.put(COL_24, c_province_state);
        contentValues.put(COL_25, c_region_country);
        contentValues.put(COL_26, c_sector);
        contentValues.put(COL_27, c_exact_site);
        contentValues.put(COL_28, c_latitude);
        contentValues.put(COL_29, c_longitude);
        contentValues.put(COL_30, c_cord_source);
        contentValues.put(COL_31, c_cord_accuracy);
        contentValues.put(COL_32, c_date_collected);
        contentValues.put(COL_33, c_collectors);
        contentValues.put(COL_34, c_elevation);
        contentValues.put(COL_35, c_elv_accuracy);
        contentValues.put(COL_36, c_depth);
        contentValues.put(COL_37, c_depth_accuracy);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }
}
