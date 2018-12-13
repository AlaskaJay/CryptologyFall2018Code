// With my computer as my forge, I craft this code in dedication to the Lame One, whom is my patron and whom I love. 

package main;

public class SixesFinder {

	public static void main(String[] args) {
		int[] freq = new int[26];
		String message = "NHSGDZAQSEVGMAESVESHAJGLAOMZOFBEEBFGOLOQITEBZAETQAHEAUVYVHHVONTOHNNNBMEMIHULIVOEENSCSOAOHPDNHPAHZHNHQHESOAOD XXOQ CATO UEOP AHEF DOEV EHES AEMA TSAR YFNA DHXT OHSJ OHJA WAKH WEHM TXQE JHLH EMEL EIJU AVAN PADN KESG ESLH OJSS ONOO IBUS QYWG YSOV SHPS EWNH ASKM AJAK TIPB JRXR HDZO DBSP TGIG ESZS HDLN CHBD NUAA TONE CYDN BDSI MOQK HNNY SHNN FTBS GXAC MSLG DSHJ OSOA JLXE QFNU LOWL SOIS AOOJ HOAI WMNC UHZB NMZO NUUN SZOO SANJ ESEZ ZISJ KSYQ AXDS KNSO OVHO PEDA PSFO DXPP XSAA ETZO ISMV AWHT HZES GESH RQZH RROJ QARC EBEB THGD EOOG MUAC VHDD HQYN AZOJ HONO EQNC QHBO IBSO JEAI EOLE UTON OLEO SNAJ AAXX HUMH XCLE RSSA QAWY FHHS PYOE OTSR QSSH VANN SXEV AOHE TSSL CKBW AMAO LHOB AKTR BJTD XOEV VHRZ AHYK HTZR SCGM EUEA LSRE NYNF EHKL HEFA KZWS QSPC CLAN PKOL XIEE EOCD NZFG OHTA AKSO CODA AANH SGHE OSOZ EHWX YNNE IHPO WIEH EYHO GOSS IWON MEVA AJCL POEB RAWZ OMWQ AZHX GTIF HPXE HYME NEAE EQNA ZNYF STOE BNSC CVSQ OHDA ERSS QCVJ HJOZ GOZH AKAO RXAX NROL EUMS GFNQ SZOW AOLE MHUS OZGO UEFU SCES IEES ZGAA LSSA UTSB AEMG EEOQ ZRAR EOCE BONZ KNQN EHMN LODA NHKX HNUN FFNK IBVN HESD FOGE X";
		int count = 0;
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				freq[message.charAt(i) - 'A']++;
				count ++;
			}
		}
		
		for(int i = 0; i < freq.length; i++) {
			System.out.println(i+ ": " + (char)(i+'A') + ": " + freq[i] + "/" + count);
		}

		Letter[] sort = new Letter[26];
		
		for(int i = 0; i < 26; i++) {
			sort[i] = new Letter((char)(i+'A'), (double)freq[i]/count); 
		}
		
		System.out.println();
		
		for(int i = 0; i < 26; i++) {
			System.out.println(sort[i].letter + ": " + sort[i].freq*100 + "%");
		}
		
		System.out.println();
		
		for(int i = 0; i < 26; i++) {
			int min = 0;
			for(int j = i; j < 26; j++) {
				if(sort[min].freq > sort[j].freq) {
					min = j;
				}
			}
			Letter temp = new Letter(sort[i].letter, sort[i].freq);
			sort[i] = new Letter(sort[min].letter, sort[min].freq);
			sort[min] = new Letter(temp.letter, temp.freq);
		}
		
		for(int i = 0; i < 26; i++) {
			System.out.println(sort[i].letter + ": " + sort[i].freq*100 + "%");
		}
		
		System.out.println();
		
		Letter temp = new Letter(sort[0].letter, sort[0].freq);
		
		for(int i = 0; i < 25; i++) {
			sort[i] = new Letter(sort[i+1].freq, sort[i+1].letter);
			System.out.println(sort[i].letter + ": " + sort[i].freq*100 + "%");
		}
		sort[25] = temp;
		
		System.out.println(sort[25].letter + ": " + sort[25].freq*100 + "%");
		
		double top6Average = 0;
		double bot6Average = 0;
		
		for(int i = 0; i < 6; i++) {
			top6Average += sort[25-i].freq;
			bot6Average += sort[i].freq;
		}
		top6Average /= 6;
		bot6Average /= 6;

		double top20Average = 0;
		double bot20Average = 0;
		
		for(int i = 0; i < 20; i++) {
			top20Average += sort[i].freq;
			bot20Average += sort[25-i].freq;
		}
		top20Average /= 20;
		bot20Average /= 20;

		System.out.println("Top 6s: " + top6Average + " and 20s would be: " + top20Average);
		System.out.println("Difference: " + (top6Average-top20Average));
		System.out.println("Bot 6s: " + bot6Average + " and 20s would be: " + bot20Average);
		System.out.println("Difference: " + (bot20Average-bot6Average));
	}
	
	public static boolean sorted() {
		return false;
	}

}
