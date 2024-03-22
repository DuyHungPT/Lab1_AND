package com.example.lab1_and;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab1_and.Adapter.SanPhamAdapter;
import com.example.lab1_and.Adapter.StudentAdapter;
import com.example.lab1_and.Model.SPModel;
import com.example.lab1_and.Model.StudentModel.Student;
import com.example.lab1_and.Model.StudentModel;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lvMain;
    List<SPModel> listSanPhamModel;
    SanPhamAdapter sanPhamAdapter;
    Button btnLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        List<Student> students = new ArrayList<>();
//        StudentModel studentModel = new StudentModel(); // Tạo một đối tượng StudentModel
//        students.add(studentModel.new Student("Nguyen Ngoc Ngan", "123456", 3.5, R.drawable.img_4));
//        students.add(studentModel.new Student("Nguyen Ngoc Son", "654321", 3.8, R.drawable.img_4));
//
//        StudentAdapter adapter = new StudentAdapter(students);
//        recyclerView.setAdapter(adapter);

        lvMain = findViewById(R.id.listviewMain);
        Button btnLuu = findViewById(R.id.btnUPDATEup);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<List<SPModel>> call = apiService.getSanPhams();

        call.enqueue(new Callback<List<SPModel>>() {
            @Override
            public void onResponse(Call<List<SPModel>> call, Response<List<SPModel>> response) {
                 if(response.isSuccessful()){
                     listSanPhamModel = response.body();

                     sanPhamAdapter = new SanPhamAdapter(getApplicationContext(),listSanPhamModel);
                     lvMain.setAdapter(sanPhamAdapter);
                 }
            }

            @Override
            public void onFailure(Call<List<SPModel>> call, Throwable t) {
                Log.e("Main", t.getMessage());
            }
        });


//        btnLuu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText edtTenSP = findViewById(R.id.edtTenSP);
//                EditText edtGiaSP = findViewById(R.id.edtGiaSP);
//                EditText edtSoLuongSP = findViewById(R.id.edtSoLuongSP);
//
//                // Lấy thông tin từ các trường nhập liệu
//                String ten = edtTenSP.getText().toString();
//                String gia = edtGiaSP.getText().toString();
//                String soLuong = edtSoLuongSP.getText().toString();
//
//
//                // Gửi yêu cầu POST đến API Server để thêm sản phẩm mới
//                Call<SPModel> call = apiService.createSanPham(new SPModel(ten,gia,soLuong));
//                call.enqueue(new Callback<SPModel>() {
//                    @Override
//                    public void onResponse(Call<SPModel> call, Response<SPModel> response) {
//                        if (response.isSuccessful()) {
//                            // Sản phẩm được thêm thành công, làm gì đó (ví dụ: hiển thị thông báo)
//                        } else {
//                            // Đã xảy ra lỗi khi thêm sản phẩm, xử lý lỗi (nếu cần)
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<SPModel> call, Throwable t) {
//                        // Xử lý lỗi khi gửi yêu cầu
//                        Log.e("Main", t.getMessage());
//                    }
//                });
//            }
//        });

    }
}
