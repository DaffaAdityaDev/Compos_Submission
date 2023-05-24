package com.example.composesubmission.data

import com.example.composesubmission.R
import com.example.composesubmission.model.ItemList

class ComicData {

    fun generateData(): List<ItemList> {
        val list = ArrayList<ItemList>()
        list.addAll(listOf(
            ComicNaruto,
            ComicBleach,
            ComicOPM,
            ComicJJK,
            ComicDemonSlayer,
            ComicAOT,
            ComicVilandSaga,
            ComicSpyxFamily,
            ComicChainsawMan,
            ComicBerserk
        ))

        return list
    }
    companion object {
        private val ComicNaruto = ItemList(
            0,
            R.drawable.narutocover,
            "Naruto",
            "Naruto adalah sebuah manga karya Masashi Kishimoto yang mengikuti perjalanan seorang ninja remaja bernama Naruto Uzumaki dalam mencapai impian dan menjalani kehidupan yang penuh petualangan di desa Konoha",
            "Manga Naruto dimulai dengan Naruto yang merupakan seorang anak yatim piatu yang hidup di desa Konoha. Dia memiliki sifat yang ceria, tetapi dihinggapi oleh kekuatan misterius yang disebut \"Kyuubi,\" sembilan ekor rubah berekor, yang dikurung dalam tubuhnya. Naruto bertekad menjadi seorang Hokage, pemimpin desa yang paling kuat, untuk mendapatkan pengakuan dari orang lain. Ia bergabung dengan tim ketujuh yang terdiri dari Sasuke Uchiha, Sakura Haruno, dan dipimpin oleh Kakashi Hatake. Mereka menghadapi berbagai macam ujian dan misi ninja.",
            "Action, Adventure, Comedy, Super Power, Martial Arts, Shounen",
            false
        )

        private val ComicBleach = ItemList(
            1,
            R.drawable.bleachcover,
            "Bleach",
            "Manga ini mengisahkan petualangan seorang remaja bernama Ichigo Kurosaki yang menjadi Shinigami, makhluk spiritual yang melawan roh jahat dan melindungi dunia manusia.",
            "Ichigo Kurosaki adalah seorang siswa SMA biasa dengan kemampuan unik untuk melihat dan berinteraksi dengan roh-roh yang tidak terlihat oleh orang lain. Suatu hari, ia bertemu dengan seorang Shinigami bernama Rukia Kuchiki yang sedang dalam misi melawan roh jahat yang disebut Hollow. Saat Rukia terluka dalam pertarungan, ia memindahkan kekuatannya pada Ichigo, yang kemudian menjadi Shinigami pengganti.\n" +
                    "\n" +
                    "Dengan kekuatan Shinigami yang baru ditemukannya, Ichigo memasuki dunia spiritual yang disebut Soul Society untuk menyelamatkan Rukia yang ditangkap oleh Shinigami lain karena melanggar hukum dengan mentransfer kekuatannya. Ichigo dan sekutunya membentuk sebuah tim yang dikenal sebagai \"Kelompok Shinigami Pengganti\" dan terlibat dalam pertempuran melawan para musuh kuat di Soul Society.\n" +
                    "\n" +
                    "Namun, perjalanan Ichigo tidak berhenti di situ. Dia terlibat dalam konflik yang lebih besar ketika munculnya makhluk jahat yang disebut Arrancar, yang merupakan Hollow yang mengambil wujud manusia. Ichigo dan teman-temannya harus berjuang melawan Arrancar yang kuat dan mempertahankan kedamaian dunia manusia.\n" +
                    "\n" +
                    "Selama perjalanan, Ichigo bertemu dengan berbagai karakter yang memiliki kekuatan spiritual yang unik dan memiliki tujuan dan motivasi mereka sendiri. Dia menghadapi musuh-musuh kuat, mengungkap misteri masa lalunya, dan memperkuat kekuatannya sebagai Shinigami.\n" +
                    "\n" +
                    "Bleach menggabungkan pertarungan aksi yang spektakuler, karakter yang kompleks, dan alur cerita yang menegangkan. Manga ini mengambil penontonnya dalam petualangan yang penuh dengan misteri, pengorbanan, dan pertempuran epik di antara dunia manusia dan dunia spiritual.\n" +
                    "\n" +
                    "Itulah sinopsis singkat manga Bleach dalam bahasa Indonesia. Cerita ini menawarkan kombinasi yang menarik antara dunia manusia dan spiritual, diisi dengan aksi dan perjuangan Ichigo serta teman-temannya dalam melawan kekuatan jahat dan melindungi kedamaian.",
            "Action, Adventure, Comedy, Super Power, Supernatural, Shounen",
            false
        )

        private val ComicOPM = ItemList(
            2,
            R.drawable.onepunchmancover,
            "One Punch Man",
            "One Punch Man adalah sebuah manga yang ditulis oleh ONE dan diilustrasikan oleh Yusuke Murata. Manga ini mengisahkan tentang Saitama, seorang pahlawan yang luar biasa kuat dan dapat mengalahkan musuh dengan sekali pukulan saja.",
            "Saitama dulunya adalah seorang pria biasa yang bosan dengan kehidupannya yang monoton dan merasa tidak ada tantangan. Setelah melalui pelatihan yang ekstrem, dia memperoleh kekuatan yang tak tertandingi. Sekarang, Saitama menjadi pahlawan yang kuat yang dikenal dengan nama One Punch Man, karena dia mampu mengalahkan setiap musuh dengan satu pukulan saja.\n" +
                    "\n" +
                    "Namun, kekuatan Saitama yang luar biasa ini juga menjadi kutukan baginya. Karena dia bisa mengalahkan musuh dengan mudah, dia merasa kehidupannya kehilangan arti dan sensasi pertarungan yang sebenarnya. Meskipun dia berjuang melawan berbagai monster dan penjahat yang muncul, dia merasa bosan dan tidak terpuaskan.\n" +
                    "\n" +
                    "Saitama bertemu dengan berbagai karakter yang mengagumi kekuatannya, seperti Genos, seorang cyborg yang menjadi muridnya. Bersama-sama, mereka berusaha menjaga perdamaian dan melindungi dunia dari ancaman para monster yang terus muncul.\n" +
                    "\n" +
                    "Dalam perjalanan mereka, Saitama dan Genos bergabung dengan Asosiasi Pahlawan, sebuah organisasi yang mengatur para pahlawan di dunia mereka. Mereka berhadapan dengan monster-monster yang semakin kuat dan ancaman yang lebih besar. Namun, Saitama tetap merasa tidak tertarik dan menghadapi semua musuh dengan sekali pukulan, mengakhiri pertarungan sebelum mereka bahkan sempat menjadi menarik.\n" +
                    "\n" +
                    "One Punch Man menghadirkan cerita yang penuh dengan aksi, komedi, dan parodi terhadap genre superhero. Saitama, sang protagonis yang tak terkalahkan, menawarkan pandangan yang unik tentang pahlawanisme dan mengeksplorasi tema tentang kebosanan, ambisi, dan arti sejati dari kekuatan.\n" +
                    "\n" +
                    "Demikianlah sinopsis singkat manga One Punch Man dalam bahasa Indonesia. Cerita ini menghadirkan kombinasi yang unik antara pertarungan yang menegangkan dan komedi yang menghibur, sambil menjelajahi perasaan dan dilema yang dialami oleh pahlawan yang sangat kuat seperti Saitama.",
            "Action, Sci-Fi, Comedy, Parody, Super Power, Supernatural, Seinen",
            false
        )

        private val ComicJJK = ItemList(
            3,
            R.drawable.jujutsukaisencover,
            "Jujustu Kaisen",
            "Jujutsu Kaisen adalah sebuah manga yang ditulis dan diilustrasikan oleh Gege Akutami. Manga ini mengisahkan tentang Yuji Itadori, seorang remaja yang tanpa sengaja terlibat dalam dunia jujutsu yang penuh dengan makhluk supernatural.",
            "Yuji Itadori adalah seorang siswa sekolah menengah yang memiliki fisik yang kuat dan bakat alami dalam atletik. Suatu hari, ketika sebuah benda kutukan yang kuat muncul di sekolahnya, Yuji tanpa ragu memegangnya untuk melindungi teman-temannya. Namun, tindakan itu tidak disangka-sangka membuka pintu bagi kekuatan jujutsu yang berbahaya.\n" +
                    "\n" +
                    "Yuji kemudian bertemu dengan Megumi Fushiguro, seorang siswa jujutsu yang mengungkapkan kepadanya bahwa dia telah terjerat dalam dunia jujutsu. Dunia ini dipenuhi oleh makhluk-makhluk jahat yang dikenal sebagai Curse dan dikendalikan oleh Jujutsu Sorcerer, para pahlawan yang melawan kekuatan gelap ini. Megumi membawa Yuji ke Tokyo Metropolitan Jujutsu Technical High School untuk bergabung dengan mereka.\n" +
                    "\n" +
                    "Di sekolah jujutsu, Yuji bertemu dengan guru eksentrik, Satoru Gojo, dan teman-teman sekelasnya, seperti Nobara Kugisaki. Bersama-sama, mereka membentuk tim untuk membasmi Curse yang mengancam kehidupan manusia. Yuji, dengan kekuatan yang terkandung dalam dirinya, harus belajar mengendalikan kekuatan jujutsu dan melindungi dunia dari ancaman yang semakin kuat.\n" +
                    "\n" +
                    "Selama perjalanan mereka, Yuji dan teman-temannya terlibat dalam pertarungan sengit dengan Curse yang mengerikan dan bertemu dengan karakter-karakter yang kuat dan misterius. Mereka menghadapi berbagai macam tantangan dan mengungkap rahasia di balik organisasi jujutsu yang lebih besar.\n" +
                    "\n" +
                    "Jujutsu Kaisen menggabungkan unsur-unsur supernatural, aksi, dan horor dalam cerita yang kompleks dan menegangkan. Manga ini mengeksplorasi tema tentang keberanian, persahabatan, dan pilihan moral sambil menghadirkan pertarungan yang penuh adrenalin dan karakter-karakter yang kuat.\n" +
                    "\n" +
                    "Itulah sinopsis singkat manga Jujutsu Kaisen dalam bahasa Indonesia. Cerita ini mengajak pembaca untuk menjelajahi dunia gelap jujutsu yang penuh dengan aksi, misteri, dan pertarungan epik yang melawan kekuatan jahat yang mengancam keseimbangan dunia manusia.",
            "Action, Demons, Supernatural, School, Shounen",
            false
        )

        private val ComicDemonSlayer = ItemList(
            4,
            R.drawable.demonslayercover,
            "Demon Slayer",
            "Demon Slayer (Kimetsu no Yaiba) adalah sebuah manga yang ditulis dan diilustrasikan oleh Koyoharu Gotouge. Manga ini mengisahkan perjalanan seorang anak bernama Tanjiro Kamado yang menjadi pembasmi iblis setelah keluarganya diserang dan adiknya, Nezuko, berubah menjadi iblis.",
            "Tanjiro Kamado adalah seorang anak muda yang tinggal di pedesaan bersama keluarganya. Suatu hari, keluarganya diserang oleh iblis yang kejam, dan satu-satunya yang selamat adalah adiknya, Nezuko. Namun, Nezuko juga berubah menjadi iblis, tetapi masih mempertahankan beberapa sifat kemanusiaan.\n" +
                    "\n" +
                    "Dorong oleh keinginan untuk mengubah Nezuko menjadi manusia lagi dan membalas dendam terhadap iblis yang membunuh keluarganya, Tanjiro bergabung dengan Korps Pembasmi Iblis. Dia mengikuti pelatihan yang keras dan menjadi seorang Pembasmi Iblis yang terampil dengan teknik bela diri bernama \"Pernafasan Air\".\n" +
                    "\n" +
                    "Tanjiro bersama dengan teman-temannya, seperti Zenitsu Agatsuma dan Inosuke Hashibira, memulai misi mereka untuk memburu iblis dan melindungi manusia dari ancaman mereka. Di perjalanan mereka, mereka bertemu dengan berbagai macam iblis, masing-masing dengan kekuatan dan cerita latar yang unik. Mereka juga menjalin persahabatan dan ikatan yang kuat satu sama lain.\n" +
                    "\n" +
                    "Namun, di balik pertarungan melawan iblis, Tanjiro mulai menyadari bahwa tidak semua iblis jahat secara alami. Beberapa di antaranya memiliki latar belakang yang tragis dan masih menyimpan sisi kemanusiaan. Dia merenungkan tujuan sebenarnya sebagai pembasmi iblis dan mengejar harapan untuk menemukan cara damai untuk mengubah iblis kembali menjadi manusia.\n" +
                    "\n" +
                    "Demon Slayer (Kimetsu no Yaiba) menggabungkan aksi, petualangan, dan elemen supernatural dalam cerita yang penuh emosi. Manga ini mengeksplorasi tema-tema seperti keluarga, persahabatan, dan perjuangan melawan kegelapan dalam perjalanan Tanjiro untuk melindungi orang yang dicintainya dan menemukan kedamaian dalam dunia yang penuh dengan iblis.\n" +
                    "\n" +
                    "Itulah sinopsis singkat manga Demon Slayer (Kimetsu no Yaiba) dalam bahasa Indonesia. Cerita ini menawarkan kombinasi yang menarik antara pertarungan aksi yang menegangkan dan narasi yang penuh emosi, sambil menggali kompleksitas karakter dan mengangkat tema-tema penting seperti keberanian dan perdamaian.",
            "Action, Demons, Historical, Shounen, Supernatural",
            false
        )

        private val ComicAOT = ItemList(
            5,
            R.drawable.shingekinokyojincover,
            "Attack On Titan",
            "Attack on Titan (Shingeki no Kyojin) adalah sebuah manga yang ditulis dan diilustrasikan oleh Hajime Isayama. Manga ini mengisahkan tentang pertempuran manusia melawan raksasa pemakan manusia yang dikenal sebagai Titan. ",
            "Cerita Attack on Titan berlangsung di dunia yang dikuasai oleh ras raksasa yang dikenal sebagai Titan. Manusia terkurung di dalam tembok raksasa yang melindungi mereka dari serangan Titan yang mengerikan. Eren Yeager, seorang remaja yang bertekad untuk membongkar misteri di balik Titan dan melindungi umat manusia, menjadi tokoh utama cerita ini.\n" +
                    "\n" +
                    "Suatu hari, tembok pertama yang melindungi manusia dari serangan Titan dilanggar oleh Titan Kolosal yang sangat besar. Serbuan ini menyebabkan Eren, bersama dengan saudara perempuannya, Mikasa Ackerman, dan teman mereka, Armin Arlert, terlibat dalam perang melawan Titan untuk bertahan hidup. Eren bersumpah untuk membunuh setiap Titan yang ada dan membalas dendam terhadap mereka yang telah merampas kehidupan manusia.\n" +
                    "\n" +
                    "Eren dan teman-temannya kemudian bergabung dengan Pasukan Penjaga Tembok dan berjuang melawan Titan dalam misi yang berbahaya. Mereka menemui berbagai macam Titan yang memiliki kekuatan dan karakteristik yang berbeda-beda, termasuk Titan Berdinding yang misterius. Dalam perjalanan mereka, mereka mengungkap rahasia di balik asal-usul Titan dan asal-usul dunia yang mereka tinggali.\n" +
                    "\n" +
                    "Attack on Titan menghadirkan alur cerita yang penuh dengan misteri, aksi yang intens, dan pertarungan epik. Manga ini juga mengeksplorasi tema-tema tentang sifat manusia, pengorbanan, dan perjuangan melawan ketakutan dan putus asa.\n" +
                    "\n" +
                    "Sinopsis ini memberikan gambaran umum tentang cerita Attack on Titan dalam bahasa Indonesia. Manga ini mengajak pembaca untuk memasuki dunia yang gelap dan kejam, di mana manusia berjuang untuk bertahan hidup dan menghadapi ancaman Titan yang mematikan.",
            "Action, Drama, Fantasy, Shounen, Super Power",
            false
        )

        private val ComicVilandSaga = ItemList(
            6,
            R.drawable.vinlandsagacover,
            "Vinland Saga",
            "Vinland Saga adalah sebuah manga yang ditulis dan diilustrasikan oleh Makoto Yukimura. Manga ini mengisahkan tentang perjalanan seorang pemuda Viking bernama Thorfinn yang terlibat dalam konflik dan pencarian akan tanah damai yang disebut Vinland.",
            "Cerita Vinland Saga berlatar belakang pada era Viking di Eropa. Thorfinn, seorang anak muda yang lahir dalam keluarga Viking terkenal, adalah seorang pejuang ulung yang membalas dendam atas kematian ayahnya oleh seorang pemimpin tentara Viking yang kejam, Askeladd.\n" +
                    "\n" +
                    "Thorfinn memutuskan untuk bergabung dengan kelompok Askeladd dan berpartisipasi dalam pertempuran demi kesempatan untuk membunuhnya. Namun, dalam perjalanannya, dia mulai melihat sisi lain dari kehidupan Viking yang keras dan kejam. Dia bertemu dengan berbagai macam karakter yang memberikan pandangan yang berbeda tentang kehidupan, kehormatan, dan arti sejati dari kekuatan.\n" +
                    "\n" +
                    "Selama perjalanan Thorfinn, tujuan dan motivasinya berubah. Dia berangsur-angsur meninggalkan hasrat balas dendamnya dan beralih ke pencarian tanah damai yang disebut Vinland, di mana tidak ada peperangan dan hanya kehidupan yang tenang. Dalam pencarian ini, dia bertemu dengan para petualang, pedagang, dan orang-orang yang mencari tempat perlindungan dari kekejaman perang.\n" +
                    "\n" +
                    "Vinland Saga menawarkan alur cerita yang penuh dengan aksi, intrik politik, dan perkembangan karakter yang mendalam. Manga ini mengeksplorasi tema-tema seperti perang, pengampunan, kehormatan, dan perubahan yang dialami oleh seorang pemuda yang tumbuh di dunia yang keras.\n" +
                    "\n" +
                    "Sinopsis ini memberikan gambaran tentang cerita Vinland Saga dalam bahasa Indonesia. Manga ini mengajak pembaca untuk menjelajahi dunia Viking yang keras dan mengikuti perjalanan Thorfinn yang menghadapi konflik batin dan berusaha mencari makna sejati dari kekuatan dan damai di tanah yang bernama Vinland.",
            "Action, Adventure, Drama, Historical, Seinen",
            false
        )

        private val ComicSpyxFamily = ItemList(
            7,
            R.drawable.spyxfamilycover,
            "Spy x Family",
            "Spy x Family adalah sebuah manga yang ditulis dan diilustrasikan oleh Tatsuya Endo. Manga ini mengisahkan tentang keluarga yang terdiri dari seorang mata-mata, seorang pembunuh bayaran, dan seorang gadis psikis yang terjebak dalam misi rahasia.",
            "Cerita Spy x Family berpusat pada seorang mata-mata berbakat yang dikenal dengan nama Loid Forger. Dia dipekerjakan oleh pemerintahan negara fiksi, Westalis, untuk menjalankan misi rahasia yang berpotensi mengubah aliran sejarah. Namun, Loid mendapati dirinya memerlukan \"keluarga\" palsu untuk berhasil menyelesaikan misi tersebut.\n" +
                    "\n" +
                    "Loid kemudian mendapatkan ide untuk membuat keluarga palsu dengan cara menikahi seorang pembunuh bayaran yang piawai bernama Yor Briar dan mengadopsi seorang gadis muda berkekuatan psikis yang dijuluki Anya. Namun, ketiganya tidak menyadari identitas asli satu sama lain, menjadikan dinamika keluarga ini sangat menarik.\n" +
                    "\n" +
                    "Loid berusaha menjalankan tugasnya sebagai mata-mata sambil mempertahankan kepribadian dan identitas palsunya sebagai suami dan ayah. Yor, dengan kemampuannya sebagai pembunuh bayaran, berusaha menjaga rahasia masa lalunya agar tidak terbongkar. Sementara itu, Anya mencoba menyembunyikan kekuatannya agar tidak diketahui oleh orang lain.\n" +
                    "\n" +
                    "Namun, ketika mereka mulai hidup bersama sebagai keluarga, mereka saling terikat dan merasakan kehangatan dan kasih sayang yang sebelumnya tidak mereka rasakan. Meskipun awalnya terjebak dalam misi palsu, mereka mulai menyadari pentingnya hubungan keluarga yang sejati dan menghadapi berbagai masalah dan kekacauan bersama-sama.\n" +
                    "\n" +
                    "Spy x Family menyajikan cerita yang penuh dengan aksi, humor, dan romansa keluarga. Manga ini mengeksplorasi tema-tema tentang pentingnya ikatan keluarga, pengorbanan, dan keberanian dalam menghadapi tantangan. Dalam perjalanan mereka, mereka juga berhadapan dengan berbagai karakter dan konspirasi yang mengancam kehidupan mereka.\n" +
                    "\n" +
                    "Sinopsis ini memberikan gambaran tentang cerita Spy x Family dalam bahasa Indonesia. Manga ini menghadirkan kombinasi yang unik antara aksi mata-mata, komedi keluarga, dan sentuhan romansa yang menghangatkan hati, sambil menjelajahi pentingnya hubungan keluarga yang sejati dan kekuatan yang bisa timbul dari cinta dan persatuan.",
            "Action, Comedy, Romance, Shounen",
            false
        )

        private val ComicChainsawMan = ItemList(
            8,
            R.drawable.chainsawmancover,
            "Chainsaw Man",
            "Chainsaw Man adalah sebuah manga yang ditulis dan diilustrasikan oleh Tatsuki Fujimoto. Manga ini mengisahkan tentang seorang pemuda bernama Denji yang menjadi pemburu iblis dan memiliki kekuatan untuk berubah menjadi seorang manusia dengan bagian tubuh berbentuk gergaji mesin.",
            "Cerita Chainsaw Man berpusat pada kehidupan Denji, seorang pemuda miskin yang terlilit hutang dan terpaksa bekerja sebagai pemburu iblis. Untuk mengatasi hutangnya, Denji bekerja sama dengan anjing iblis bernama Pochita dan menggabungkan kekuatannya dengan Pochita yang dapat berubah menjadi gergaji mesin. Dengan perpaduan kekuatan mereka, Denji menjadi Chainsaw Man.\n" +
                    "\n" +
                    "Sebagai Chainsaw Man, Denji berjuang melawan iblis-iblis yang mengancam umat manusia. Ia bekerja di bawah bimbingan Badan Keamanan Iblis Jepang, yang mengatur dan mengawasi para pemburu iblis. Denji bertemu dengan berbagai karakter dalam perjalanan hidupnya, termasuk para pemburu iblis lainnya seperti Power dan Aki Hayakawa.\n" +
                    "\n" +
                    "Namun, hidup Denji berubah drastis ketika ia terlibat dalam konflik yang lebih besar yang melibatkan kekuatan iblis yang kuat dan organisasi rahasia. Denji harus menghadapi musuh-musuh yang semakin tangguh sambil mengungkap misteri di balik asal-usul kekuatannya dan menghadapi pilihan yang sulit dalam pertarungan melawan kegelapan.\n" +
                    "\n" +
                    "Chainsaw Man menghadirkan cerita yang penuh dengan aksi, kekerasan, dan elemen supernatural. Manga ini mengeksplorasi tema-tema seperti identitas diri, kehancuran, dan keserakahan manusia. Dalam perjalanan Denji, ia juga mengalami perubahan karakter dan tumbuh sebagai individu yang lebih kuat dan berani.\n" +
                    "\n" +
                    "Sinopsis ini memberikan gambaran tentang cerita Chainsaw Man dalam bahasa Indonesia. Manga ini menawarkan kombinasi yang gelap dan penuh tindakan, dengan fokus pada perjuangan seorang pemuda yang memiliki kekuatan gergaji mesin dalam melawan iblis dan mengungkap rahasia yang mengancam kehidupan manusia.",
            "Action, Demons, Supernatural, Shounen",
            false
        )

        private val ComicBerserk = ItemList(
            9,
            R.drawable.bersecover,
            "Berserk",
            "Berserk adalah sebuah manga yang ditulis dan diilustrasikan oleh Kentaro Miura. Manga ini mengisahkan tentang Guts, seorang prajurit bayaran yang terlibat dalam perang, kekerasan, dan pertarungan melawan makhluk-makhluk supranatural.",
            "Cerita Berserk berlangsung di dunia yang keras dan gelap yang dipenuhi oleh kekerasan dan kekejaman. Protagonis utama, Guts, adalah seorang prajurit bayaran yang mempertaruhkan hidupnya dalam pertempuran demi bertahan hidup. Ia memiliki masa lalu yang kelam dan penuh penderitaan yang membentuk kepribadiannya yang keras dan dingin.\n" +
                    "\n" +
                    "Guts, yang juga dikenal sebagai \"The Black Swordsman\", melakukan perjalanan seorang diri melalui daratan yang penuh dengan iblis, roh jahat, dan korupsi manusia. Ia berusaha membalas dendam terhadap makhluk-makhluk jahat yang menghancurkan hidupnya dan menemukan tempat di dunia yang kejam ini.\n" +
                    "\n" +
                    "Selama perjalanannya, Guts bertemu dengan sekelompok pengikut yang setia, termasuk Puck, seorang elf kecil dengan kekuatan magis, dan Casca, seorang wanita yang memiliki masa lalu yang gelap. Mereka membentuk ikatan yang kuat dan saling mendukung dalam pertarungan melawan musuh-musuh yang kuat dan ganas.\n" +
                    "\n" +
                    "Berserk menampilkan alur cerita yang penuh dengan aksi, kekerasan, dan elemen supernatural. Manga ini mengeksplorasi tema-tema seperti kehancuran, keberanian, persahabatan, dan perjuangan melawan kegelapan dalam diri manusia. Dalam perjalanan Guts, ia menghadapi berbagai rintangan dan musuh yang menguji kekuatan dan keteguhannya.\n" +
                    "\n" +
                    "Sinopsis ini memberikan gambaran tentang cerita Berserk dalam bahasa Indonesia. Manga ini menawarkan pengalaman yang intens dan gelap, dengan penekanan pada pertempuran epik, pengembangan karakter yang kompleks, dan eksplorasi tema-tema yang dalam. Berserk adalah sebuah cerita yang menantang dan memikat perhatian pembaca dengan visualnya yang kuat dan atmosfer yang memikat.",
            "Action, Adventure, Demons, Drama, Fantasy, Horror, Military, Romance, Seinen, Supernatural",
            false
        )
    }
}
