
import java.util.Scanner;
/**
 * @file hw9_170420050
 * @assignment 9
 * @date 16.05.2022
 * @author yigit bayraktaroglu yigitbayraktaroglu@marun.edu.tr
 */

public class Main extends Reader {
    //Değişkenler tanımlandı.
    static int winnerName;
    static Scanner scanner = new Scanner(System.in);
    static int oyuncu1wincount = 0;
    static int oyuncu2wincount = 0;
    static  String[] oyuncu1;
    static String[] oyuncu2;
    //Bir sonraki raunda geçerken yapılan işlemlerin bulunduğu fonksiyon
    static void nextRaund(BinarySearchTree oyuncu1tree, BinarySearchTree oyuncu2tree,
                          int winnerName)
    {
        if(winnerName==1){
            int temp1=maxValue(oyuncu2tree.root);
            int temp2=oyuncu1tree.root.key;
            oyuncu1tree.insert(temp1);
            oyuncu2tree.deleteKey(temp1);
            oyuncu2tree.insert(temp2);
            oyuncu1tree.deleteKey(temp2);


        }else{
            int temp1=maxValue(oyuncu1tree.root);
            int temp2=oyuncu2tree.root.key;
            oyuncu2tree.insert(temp1);
            oyuncu1tree.deleteKey(temp1);
            oyuncu1tree.insert(temp2);
            oyuncu2tree.deleteKey(temp2);
        }


    }
//esitlik durumunda yapılacak işlemlerin bulunduğu fonksiyon
    static void esitlik(BinarySearchTree oyuncu1tree, BinarySearchTree oyuncu2tree) {
        String temp;
        temp=oyuncu1[0];
        oyuncu1[0]=oyuncu2[0];
        oyuncu2[0]=temp;
        for (String p : oyuncu1)
            oyuncu1tree.insert(Integer.parseInt(p));
        for (String p : oyuncu2)
            oyuncu2tree.insert(Integer.parseInt(p));
    }
//oyunun çalıştığı ve yazdırıldığı foknskiyon
    static void game(BinarySearchTree oyuncu1tree, BinarySearchTree oyuncu2tree) {
        resetTemp();
        /*----------------------------------------------------------*/
        System.out.println("--------------------------");
        System.out.println("Oyuncu1 postorder");
        printPostorder(oyuncu1tree.root);
        int oyuncu1soy = countAllChildren(oyuncu1tree.root);
        System.out.println("\noyuncu1 toplam soy sayisi:" + oyuncu1soy);
        resetTemp();
        System.out.println("--------------------------");
        System.out.println("Oyuncu2 postorder");
        printPostorder(oyuncu2tree.root);
        int oyuncu2soy = countAllChildren(oyuncu2tree.root);
        System.out.println("\noyuncu2 toplam soy sayisi:" + oyuncu2soy);
        System.out.println("--------------------------");
        /*----------------------------------------------------------*/

        int winner = Math.min(oyuncu1soy, oyuncu2soy);
        if (oyuncu1soy == oyuncu2soy) {
            esitlik(oyuncu1tree,oyuncu2tree);
            game(oyuncu1tree,oyuncu2tree);
        } else {
            if (winner == oyuncu1soy) {
                System.out.println("****Oyuncu1 bu raundu kazandi.****");
                winnerName=1;
                oyuncu1wincount++;
            } else {
                System.out.println("****Oyuncu2 bu raundu kazandi.****");
                winnerName=2;
                oyuncu2wincount++;
            }
        }
        /*----------------------------------------------------------*/
        System.out.println("Toplam Skor:\nOyuncu1:" + oyuncu1wincount + "\nOyuncu2:" + oyuncu2wincount);
        System.out.println("--------------------------");
            if(oyuncu1wincount==20 || oyuncu2wincount==20 ||Math.abs(oyuncu1wincount-oyuncu2wincount)==5){
                System.out.println("-------OYUN BITTI-------");
                if (oyuncu1wincount>oyuncu2wincount)
                System.out.println("-------KAZANAN OYUNCU1-------");else System.out.println("-------KAZANAN OYUNCU2-------");
            }else{
                System.out.println("Devam icin ->1\nDurmak icin->0");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    nextRaund(oyuncu1tree, oyuncu2tree, winnerName);
                    game(oyuncu1tree, oyuncu2tree);
                }
            }
    }

    public static void main(String[] args) {
        BinarySearchTree oyuncu1tree = new BinarySearchTree();
        BinarySearchTree oyuncu2tree = new BinarySearchTree();
        oyuncu1=readFile(oyuncu1tree, "src/oyuncu1.txt");
        oyuncu2=readFile(oyuncu2tree, "src/oyuncu2.txt");
        game(oyuncu1tree, oyuncu2tree);
    }
}
