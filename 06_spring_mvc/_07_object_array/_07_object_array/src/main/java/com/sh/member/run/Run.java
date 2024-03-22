package com.sh.member.run;

import com.sh.member.model.vo.Gold;
import com.sh.member.model.vo.Silver;
import com.sh.member.model.vo.VIP;
import com.sh.member.model.vo.VVIP;
import com.sh.member.repository.MemberRepository;

public class Run {

    public static void main(String[] args){
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.silverInsert(new Silver("홍길동", "Silver",1000));
        memberRepository.silverInsert(new Silver("김말똥", "Silver",2000));
        memberRepository.silverInsert(new Silver("고길동", "Silver",3000));
        memberRepository.goldInsert(new Gold("김회장", "Gold",1000));
        memberRepository.goldInsert(new Gold("이회장", "Gold",2000));
        memberRepository.goldInsert(new Gold("오회장", "Gold",3000));
        // vip 추가
        memberRepository.vipInsert(new VIP("이부자", "Vip",10000));
// vvip 추가
        memberRepository.vvipInsert(new VVIP("김갑부", "VVip",100000));

        memberRepository.printData();
    }

}

