package com.example.wl_wouk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var title: List<String>, private var details: List<String>, private var images: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tvTitle)       // val itemTitle은 TextView형식, itemView를 가져오는데, Id를 통해서 찾고, 그 레이아웃의 아이디는 tvTitle이야.
        val itemDetails: TextView = itemView.findViewById(R.id.tvAbout)
        val itemImage: ImageView = itemView.findViewById(R.id.ivImage)

/*      클릭했을 때 Toast가 나오도록 한 코드
        init {
            itemImage.setOnClickListener { v: View->
                val position = adapterPosition
                Toast.makeText(itemView.context,"You clicked on item #${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
*/
    }
    // 1 (만들 페이지의 전체 길이)
    override fun getItemCount(): Int {      // 이 클래스 내에서 가장 먼저 실행되는 함수
        return title.size
    }

    // 2 (뷰홀더가 생성되는 함수)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.Pager2ViewHolder {      // getItemCount() 다음으로 호출되는 함수
        // return 값으로 ViewHolder 객체를 만든다.
        // (item_page와 연결해줌. parent를 루트로 두고, parent의 자식이 아닌 그냥 레이아웃으로 설정) => itemView, 결국은 item_page랑 연결하겠다는 얘기
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    // 3 (생성된 뷰홀더에 데이터를 바인딩 해주는 함수)
   override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]     // holder.setData(itemTitle[position])의 형태도 가능한 것 같음
        holder.itemDetails.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }
}