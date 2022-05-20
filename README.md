# VYVA-hw9Veri Yapıları Dersi 2.Ödev

<p>Yiğit Bayraktaroğlu 170420050</p>
<h2> Ödev İçeriği:</h2>
<p>
Java programlama dili ile yazacağınız programda ikili arama ağacı (Binary Search Tree-BST) veri
yapısını programlayarak aşağıdaki detayı verilen problemin çözümünü geliştirmeniz
istenmektedir.
İstenen ödev için java konsol uygulamasının geliştirilmesi beklenmektedir. </p>
<h2>İşlem adımları:</h2>
<p>
Geliştirilecek uygulama Java konsol uygulaması olup çalıştırıldığında oyuncu1.txt ve oyuncu2.txt dosyalarını
okuyacaktır. İçerisinde rastgele sayılar bulunan bu iki dosyada sayılar # karakteri ile ayrılmıştır. Program iki ayrı
.txt dosyadan okuduğu veriyi iki farklı ikili arama ağacına yerleştirecektir (dosyadan okunduğu sıra ile.!). İkili arama
ağaçlarından biri oyuncu1 isimli dosyadan okunan sayılardan oluşturulacak, diğeri ise oyuncu2 isimli dosyadan okunan
sayılardan oluşacaktır. Ağacın her düğümünde soy_sayisi isimli bir özellik bulunmalı ve düğümün altında bulunan ve
düğümden ulaşılabilen bütün alt düğümlerin sayısını tutmalıdır. Her iki dosyada bulunan sayı adedi eşittir. Örnek dosya
içerikleri aşağıdaki gibi ise; oyuncu1.txt 85#12#7#99#83#105#90#87#101#97 oyuncu2.txt 12#5#8#63#45#38#34#60#47#51
Verilen dosya içeriklerine göre oluşacak BST ağacı; Oyuncu1 Toplam Soy Sayısı: 9+ 2 + 5 + 0+ 0+ 2 +0+ 0 + 1 +0 = 19
Oyuncu2 Toplam Soy Sayısı: 9+ 1 + 6 + 0+ 5+ 1 +2+ 0 + 1 +0 = 25 Bu hesaplama sonucuna göre, toplam soy sayısı az olan
turu kazanır. Eğer herhangi bir turda soy sayıları eşit olursa kök düğümler karşılıklı olarak değiştirilir ve
kendilerinden silinir, kök düğümler değiştirildiğinde yeni kök düğüme göre BST ağaç olma kuralı işletilir. 5 tur üst
üste kazanan veya 20 turun sonunda skoru fazla olan oyunu kazanır.</p>
<p>Geliştirilecek program çalıştığında doğrudan dosyadan verileri okuyacak ve okunan verilere
uygun olarak gerekli ağaç veri modeli oluşturulacaktır.
Program ile dosyadan veriler okuduktan sonra dosyadaki verilere uygun olarak BST
oluşturulacaktır ve aşağıdaki gibi bir ekran çıktısı oluşacaktır. Kullanıcı devam seçeneğini
seçtiğinde bir sonraki tura devam edilecektir, bu süreç oyunculardan herhangi birinin oyunu
kazanmasına kadar devam edecektir ve program kazanan oyuncu ve skorunu belirtip
sonlanacaktır.</p>
<p>
Kazanan oyuncu karşı tarafın (oyuncunun) ağacından en büyük değere sahip olan düğümü
kendi ağacına ekler ve karşı taraftaki ağaçtan siler. Bu işlemden sonra kazanan oyuncu kendi
ağacının kök düğümünü karşı oyuncunun ağacına verir (ekler) ve kendisinden siler.
İkili arama ağacında silme kuralı olarak eğer silinen düğüm (node) iki adet çocuğa sahip ise,
düğümün sol alt ağacının maksimum değeri ile değiştirme yöntemi kullanılır.</p>

