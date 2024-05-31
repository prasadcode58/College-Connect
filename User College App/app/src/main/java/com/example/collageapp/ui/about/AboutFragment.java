package com.example.collageapp.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.collageapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.aids, "Artificial Intelligence and Data Science", "Artificial Intelligence (AI) an interdisciplinary science with multiple approaches and Data Science (DS) is the field of study which encompasses various roles such as data analysts, decision scientists and business intelligence developers. As data is the main oil for every application, DS is helpful for students to draw meaningful insights from big data and acquire skill-sets to deal with numerous real time applications in this field."));
        list.add(new BranchModel(R.drawable.civileng, "Civil Engineering", "Department of Civil engineering at Vishwakarma Institute of Information Technology is highly committed to craft engineers by providing training from the root level to the fruit. Department has an intake of 180 students per year. In addition to the prescribed syllabus we provide them an atmosphere where every student gets an opportunity to maximize their latent talents. Department have latest infrastructure facilities with the global standards."));
        list.add(new BranchModel(R.drawable.compsic, "Computer Engineering", "Computer Engineering course is all about the core concepts of computer science that includes the subjects such as networking, operation system, database, mobile computing etc. These are the basics for implementation and deployment levels where the computer engineering field requires candidates to be more productive and deployable, hence, it requires them to be good at communications."));
        list.add(new BranchModel(R.drawable.entceng, "Electronics and Tele-communications", "The curriculum in electronics and telecommunication engineering puts greater importance on deep understanding of fundamental principles of analog & digital communication, microwave engineering, mobile communication, microprocessor and controller engineering & audio and video communications systems."));
        list.add(new BranchModel(R.drawable.appliedsci, "Engineering and Applied Sciences", "Engineering & Applied Sciences department plays a parental role for the budding engineers by offering Class Teacher and Batch Guardian scheme, through which attendance, academic performance and students' overall development is monitored. At Engineering and Applied Science department, professional and personal guidance by the qualified counselor is provided to students, as and when required."));
        list.add(new BranchModel(R.drawable.iteng, "Information Technology", "IT is commonly offered as a 3-4 year course which focuses on exploring IT technologies, their applications, computer systems, IT engineering, and much more. As the Information Technology industry is ever-evolving, its applications are widespread across different industries from business and management to health sciences."));
        list.add(new BranchModel(R.drawable.mecheng, "Mechanical Engineering", "The Mechanical Engineering department has well Qualified, Experienced and committed faculty towards high academic standards, Industry connects and Research. The Department expertise is distributed in three domain namely Design, Thermal, Manufacturing and Materials. The curriculum is balanced through industrial involvement, project based learning (PBL) and industrial Internship."));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.branch);

        viewPager.setAdapter(adapter);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=BRACT's, Vishwakarma Institute of Information Technology");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}