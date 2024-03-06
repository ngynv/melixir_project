package com.example.melixir.ultis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.melixir.R;
import com.example.melixir.model.Giohang;
import com.example.melixir.model.Product;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tensp, giasp, mota;
    Button btnThem;
    Spinner spinner;
    Toolbar toolbar;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        initControl();
        initData();
        setSupportActionBar(toolbar); // Thêm dòng này để đặt Toolbar làm ActionBar
        actionToolbar();
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    private void initView() {
        tensp = findViewById(R.id.txtten);
        giasp = findViewById(R.id.txtgia);
        mota = findViewById(R.id.txtMotachitiet);
        btnThem = findViewById(R.id.btnThemvaogiohang);
        spinner = findViewById(R.id.spinner);
        toolbar = findViewById(R.id.toolbar);
    }

    private void initControl() {
        btnThem.setOnClickListener(this);
    }

    private void initData() {
        product = (Product) getIntent().getSerializableExtra("selected_product");
        if (product != null) {
            tensp.setText(product.getNamePro());
            mota.setText(product.getDescriptionPro());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            giasp.setText("Gía:" + decimalFormat.format(Double.parseDouble(product.getPrice())) + "Đ");

            //Chọn số lượng sp
            Integer[] soluong = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, soluong);
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnThemvaogiohang) {
            // Xử lý logic khi người dùng click vào nút "Thêm vào giỏ hàng"
            // Code logic xử lý thêm sản phẩm vào giỏ hàng ở đây
        }
    }

    private void actionToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void xulytrove(View view) {
        Intent intent = new Intent(DetailActivity.this, ProductActivity.class);
        startActivity(intent);
    }
}