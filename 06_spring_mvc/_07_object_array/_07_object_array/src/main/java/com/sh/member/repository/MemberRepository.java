package com.sh.member.repository;

import com.sh.member.model.vo.Gold;
import com.sh.member.model.vo.Silver;
import com.sh.member.model.vo.VIP;
import com.sh.member.model.vo.VVIP;

public class MemberRepository
{

    static final int MAXIMUM_MEMBER = 10;

    private int numOfSilver = 0;

    private int numOfGold = 0;

    private int numOfVip = 0;

    private int numOfVvip = 0;

    private Gold[] goldMembers = new Gold[MAXIMUM_MEMBER];

    private Silver[] silverMembers = new Silver[MAXIMUM_MEMBER];

    private VIP[] vipMembers = new VIP[MAXIMUM_MEMBER];

    private VVIP[] vvipMembers = new VVIP[MAXIMUM_MEMBER];

    public MemberRepository() {
    }

    public void silverInsert(Silver theSilver) {
        if (numOfSilver < MAXIMUM_MEMBER) {
            silverMembers[numOfSilver] = theSilver;
            numOfSilver += 1;
        }

    }

    public void goldInsert(Gold theGold) {
        if (numOfGold < MAXIMUM_MEMBER) {
            goldMembers[numOfGold] = theGold;
            numOfGold += 1;
        }

    }
    public void vipInsert(VIP theVip) {
        if (numOfVip < MAXIMUM_MEMBER) {
            vipMembers[numOfVip] = theVip;
            numOfVip += 1;
        }

    }
    public void vvipInsert(VVIP theVvip) {
        if (numOfVvip < MAXIMUM_MEMBER) {
            vvipMembers[numOfVvip] = theVvip;
            numOfVvip += 1;
        }

    }


    public void printData() {

        System.out.println("" +
                "---------------------------<<회원정보>>---------------------------\n" +
                "이름              등급             포인트         이자포인트\n" +
                "-----------------------------------------------------------------");
        for (int i = 0; i < numOfSilver; i++) {
            Silver theSilver = silverMembers[i];
            System.out.printf("%s              %s             %d         %f",
                    theSilver.getName(), theSilver.getGrade(), theSilver.getPoint(), theSilver.getInterestPoint());
            System.out.println();
        }
        for (int i = 0; i < numOfGold; i++) {
            Gold theGold = goldMembers[i];
            System.out.printf("%s              %s             %d         %f",
                    theGold.getName(), theGold.getGrade(), theGold.getPoint(), theGold.getInterestPoint());
            System.out.println();
        }
        for (int i = 0; i < numOfVip; i++) {
            VIP theVip = vipMembers[i];
            System.out.printf("%s              %s             %d         %f",
                    theVip.getName(), theVip.getGrade(), theVip.getPoint(), theVip.getInterestPoint());
            System.out.println();
        }
        for (int i = 0; i < numOfVvip; i++) {
            VVIP theVvip = vvipMembers[i];
            System.out.printf("%s              %s             %d         %f",
                    theVvip.getName(), theVvip.getGrade(), theVvip.getPoint(), theVvip.getInterestPoint());
            System.out.println();
        }
    }

    public int getNumOfSilver() {
        return numOfSilver;
    }

    public void setNumOfSilver(int numOfSilver) {
        this.numOfSilver = numOfSilver;
    }

    public int getNumOfGold() {
        return numOfGold;
    }

    public void setNumOfGold(int numOfGold) {
        this.numOfGold = numOfGold;
    }

    public Gold[] getGoldMembers() {
        return goldMembers;
    }

    public void setGoldMembers(Gold[] goldMembers) {
        this.goldMembers = goldMembers;
    }

    public Silver[] getSilverMembers() {
        return silverMembers;
    }

    public void setSilverMembers(Silver[] silverMembers) {
        this.silverMembers = silverMembers;
    }
}
