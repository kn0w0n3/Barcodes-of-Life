package com.example.bold_ng;

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
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
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
}
