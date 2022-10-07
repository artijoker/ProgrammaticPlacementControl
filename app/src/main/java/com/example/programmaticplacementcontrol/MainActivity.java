package com.example.programmaticplacementcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<City> cities = createTestData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createListCities());

    }

    private LinearLayout createListCities() {

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        TextView title = new TextView(this);
        title.setText("Список городов");
        title.setLayoutParams(params);

        title.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        title.setPadding(0, 0, 0,
                (int) this.getResources().getDimension(R.dimen.cities_list_title_margin));
        title.setTextSize(26);
        linearLayout.addView(title);

        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);

        list.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        list.setPadding(
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_horizontal),
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_vertical),
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_horizontal),
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_vertical)
        );
        ScrollView scrollView = new ScrollView(this);
        for (City city : cities) {
            Button button = new Button(this);
            button.setTag(city);

            button.setText(city.getName());
            button.setLayoutParams(params);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setContentView(createCityInfo((City) view.getTag()));
                }
            });

            button.setTextSize(20);
            list.addView(button);
        }
        scrollView.addView(list);

        linearLayout.addView(scrollView);
        return linearLayout;
    }


    private LinearLayout createCityInfo(City city) {

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        Button button = new Button(this);
        button.setText("< Назад");
        button.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(createListCities());
            }
        });
        linearLayout.addView(button);

        TextView title = new TextView(this);
        title.setText(city.getName());
        title.setLayoutParams(params);
        title.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        title.setTextSize(26);
        linearLayout.addView(title);

        ScrollView scrollView = new ScrollView(this);
        LinearLayout info = new LinearLayout(this);
        info.setOrientation(LinearLayout.VERTICAL);
        info.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        info.setPadding(
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_horizontal),
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_vertical),
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_horizontal),
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_vertical)
        );

        LinearLayout generalInfo = new LinearLayout(this);
        generalInfo.setOrientation(LinearLayout.VERTICAL);
        generalInfo.setLayoutParams(params);
        generalInfo.setPadding(0,
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_vertical),
                0,
                (int) this.getResources().getDimension(R.dimen.cities_list_margin_vertical)
        );
        TextView titleGeneralInfo = new TextView(this);
        titleGeneralInfo.setText("Общая информация:");
        titleGeneralInfo.setLayoutParams(params);
        titleGeneralInfo.setTextSize(21);
        generalInfo.addView(titleGeneralInfo);

        TextView population = new TextView(this);
        population.setText("Население: " + city.getPopulation() + " чел.");
        population.setLayoutParams(params);
        generalInfo.addView(population);

        TextView airports = new TextView(this);
        airports.setText("Аэропортов: " + city.getAirports());
        airports.setLayoutParams(params);
        generalInfo.addView(airports);

        TextView railwayStations = new TextView(this);
        railwayStations.setText("Железнодорожных вокзалов: " + city.getRailwayStations());
        railwayStations.setLayoutParams(params);
        generalInfo.addView(railwayStations);

        TextView universities = new TextView(this);
        universities.setText("Вузов: " + city.getUniversities());
        universities.setLayoutParams(params);
        generalInfo.addView(universities);

        TextView museums = new TextView(this);
        museums.setText("Музеев: " + city.getMuseums());
        museums.setLayoutParams(params);
        generalInfo.addView(museums);

        TextView libraries = new TextView(this);
        libraries.setText("Библиотек: " + city.getLibraries());
        libraries.setLayoutParams(params);
        generalInfo.addView(libraries);

        TextView parksAndGardens = new TextView(this);
        parksAndGardens.setText("Парков и садов: " + city.getParksAndGardens());
        parksAndGardens.setLayoutParams(params);
        generalInfo.addView(parksAndGardens);

        info.addView(generalInfo);

        TextView aboutCity = new TextView(this);
        aboutCity.setText("О городе:");
        aboutCity.setLayoutParams(params);
        aboutCity.setTextSize(21);
        info.addView(aboutCity);
        TextView infoAboutCity = new TextView(this);
        infoAboutCity.setText(city.getInfo());
        infoAboutCity.setLayoutParams(params);
        info.addView(infoAboutCity);

        scrollView.addView(info);
        linearLayout.addView(scrollView);


        return linearLayout;
    }


    private List<City> createTestData() {
        List<City> cities = new ArrayList<>();
        cities.add(
                new City("Москва",
                        12_635_466, 5, 9, 275,
                        440, 500, 121,
                        "Москва – столица России, политический, экономический и культурный центр. " +
                                "Самый населенный город России и Европы. \n" +
                                "Для многих россиян и иностранцев российская столица – это город больших возможностей." +
                                "По инфраструктуре и жизненному укладу Москва во многом похожа на европейскую столицу, а ее жители – на типичных обитателей мегаполисов от Лондона до Нью-Йорка. \n" +
                                "Это делает ее понятной и легкой для адаптации иностранцев."
                )
        );
        cities.add(
                new City("Санкт-Петербург",
                        5_377_503, 1, 5, 103,
                        235, 79, 130,
                        "Санкт-Петербург – город на побережье Финского залива. " +
                                "Основанный Петром I в 1703 году, он на протяжении двух веков был столицей России, свидетелем важнейших исторических событий. " +
                                "Город часто называют «Северной Венецией» за его уникальную архитектуру. \n" +
                                "Петербург также известен своей особой творческой атмосферой, притягивающей к нему романтиков, художников и поэтов." +
                                "Санкт-Петербург находится в 400 км от Хельсинки. \n" +
                                "Из центра города в финскую столицу и обратно несколько раз в день ходят автобусы, экспресс-поезда, паромы. \n" +
                                "Время в пути от 3,5 до 6 часов в зависимости от вида транспорта. \n" +
                                "Возможность частых поездок в города Европы – одно из преимуществ жизни в городе на Неве, \n" +
                                "главное заранее позаботиться о шенгенской визе (в посольствах европейских стран в вашей стране)."
                )
        );
        cities.add(
                new City("Казань",
                        1_259_173, 1, 2, 32,
                        42, 107, 8,
                        "Казань – один из старейших городов России расположен на берегу Волги, в 820-ти километрах от Москвы. \n" +
                                "Столица Татарстана, где проживают представители 115 национальностей. \n" +
                                "Более 50% населения татары, на втором месте по численности – русские.\n" +
                                "Русский и татарский являются государственными и равноправными языками. \n" +
                                "Татарстан – светская республика, в которой зарегистрировано свыше 1 000 религиозных объединений. \n" +
                                "Наиболее распространены ислам и православие. " +
                                "В Казани есть мечети, православные, католические храмы и церкви, " +
                                "синагога и другие религиозные сооружения и центры."
                )
        );
        cities.add(
                new City("Нижний Новгород",
                        1_233_949, 1, 1, 50,
                        42, 53, 15,
                        "Нижний Новгород – город в европейской части России, расположен в месте слияния рек Оки и Волги. \n" +
                                "Был основан в 1221 году. Находится в 400 км от Москвы. \n" +
                                "Один из древнейших торговых и ремесленных городов России. " +
                                "Нижегородский кремль – главная достопримечательность и гордость города. \n" +
                                "Построен в начале XVI века в качестве боевой крепости. \n" +
                                "Сегодня по этому уникальному музею под открытым небом наряду с обычными экскурсиями проводят туры с элементами театрализованных представлений или квестов. \n" +
                                "Рождественская улица – одна из центральных улиц города, на которой сохранились дома середины XVIII-XIX вв. \n" +
                                "Прогулка по Рождественской подарит хорошее настроение и окунет в атмосферу прошлого."
                )
        );
        cities.add(
                new City("Екатеринбург",
                        1_493_600, 1, 1, 27,
                        40, 62, 39,
                        "Екатеринбург – четвертый по числу жителей город России, столица Урала. \n" +
                                "Находится в центре Евразийского континента, на границе Европы и Азии, более чем в 1 600 км к востоку от Москвы.\n" +
                                "На различных площадках Екатеринбурга организуют десятки культурных мероприятий. \n" +
                                "Так, в молодежном культурном центре «Урал» проходят джазовые и рок-концерты, спектакли, конкурсы, фестивали, презентации, книжные выставки и литературные чтения. \n" +
                                "Работают дискуссионные клубы, участники которых обсуждают современное искусство и культуру. \n" +
                                "Окунуться в атмосферу российского города начала XIX века могут посетители Литературного квартала – сквера, на территории которого находятся кузница, \n" +
                                "конюшня, каретный сарай, театр и несколько музеев, в том числе книжный и кукольный. \n" +
                                "Каждое лето улицы Екатеринбурга превращаются в яркие объекты стрит-арта – в городе проходит фестиваль «Стенограффия». \n" +
                                "В нем участвуют сотни художников из России и других стран мира."
                )
        );
        cities.add(
                new City("Новосибирск",
                        1_621_330, 1, 1, 34,
                        42, 78, 19,
                        "Новосибирск – научный центр России. \n" +
                                "В городе находится свыше 100 научно-исследовательских организаций, \n" +
                                "Академгородок, Президиум Сибирского отделения Российской академии наук (РАН), там живут и работают более 1 500 докторов наук и 3 400 кандидатов наук.\n" +
                                "Новосибирск – третий в России по численности населения, самый быстрорастущий в мире город-миллионник, \n" +
                                "в котором проживают представители свыше двух десятков национальностей. \n" +
                                "Наряду с православными храмами и церквями в городе есть мечети, " +
                                "католический собор, синагога, буддистский храм, другие религиозные сооружения и центры."
                )
        );

        cities.add(
                new City("Томск",
                        570_776, 1, 1, 8,
                        8, 31, 6,
                        "Томск – город на востоке Западной Сибири на берегу реки Томь. Столица Томской области.\n" +
                                "В 1896 году в Томске был основан первый в Сибири политехнический вуз, к 40-м годам XX века город уже имел репутацию российского центра науки и образования. \n" +
                                "Сегодня студенты составляют пятую часть населения Томска – более 117 тысяч человек.\n" +
                                "Томск – старейший в Сибири научный, образовательный и инновационный центр, где находятся не менее 15 научно-исследовательских организаций, \n" +
                                "8 вузов, особая экономическая зона. В городе развиты наукоёмкий бизнес, IT-индустрия."
                )
        );

        cities.add(
                new City("Владивосток",
                        600_871, 1, 1, 28,
                        30, 20, 11,
                        "Владивосток – портовый город на российском Дальнем Востоке. Расположен на полуострове, омываемом Японским морем. \n" +
                                "Столица Приморского края. Современный, меняющийся на глазах город: например, всего за несколько последних лет там были построены уникальные мосты Русский и Золотой рог, гигантский университетский кампус, Приморский оперный театр. \n" +
                                "В городе проходят события мирового уровня, в их числе саммит АТЭС, Восточный экономический форум.\n" +
                                "Владивосток от Сеула отделяют 750 км, от Пекина – 1 335 км, от Токио – чуть более тысячи. \n" +
                                "Местные туроператоры предлагают недорогие перелеты, паромные и круизные туры в азиатские страны, в том числе в Таиланд, Вьетнам, Сингапур. \n" +
                                "Главное перед выездом в Россию позаботиться о визе (в посольствах азиатских стран, которые вы намерены посетить)."
                )
        );
        cities.add(
                new City("Петрозаводск",
                        280_890, 1, 1, 9,
                        23, 16, 6,
                        "Петрозаводск – столица республики Карелия, расположен на северо-западе России, на берегу Онежского озера, примерно в 400 км от Санкт-Петербурга и в 1 100 от Москвы. \n" +
                                "Город известен своей необычной природой и памятниками архитектуры.\n" +
                                "На набережной Петрозаводска раскинулся своеобразный музей под открытым небом, экспонаты которого – оригинальные арт-объекты, \n" +
                                "подаренные столице Карелии городами-побратимами. " +
                                "Среди них – «Рыбаки» (Дулут, США), «Дерево желаний» (Умео, Швеция), «Место встречи» (Мо и Рана, Норвегия)." +
                                "Петрозаводск – площадка проведения сразу нескольких фестивалей, в том числе международных конкурса снежных и ледовых скульптур «Гиперборея» и \n" +
                                "фестиваля живой музыки «Воздух». Летом в городе проходит музыкальный фестиваль \n" +
                                "Петрозаводской консерватории имени А. К. Глазунова «Белые ночи Карелии» и ландшафтный фестиваль «Созвучие белых ночей»."
                )
        );
        cities.add(
                new City("Самара",
                        1_136_709, 1, 1, 29,
                        29, 79, 9,
                        "Самара – город в европейской части России, расположенный на левом берегу Волги. \n" +
                                "Центр космической и авиационной промышленности страны. Один из старинных городов России. \n" +
                                "С пристани Самарского речного вокзала отдыхающие отправляются в теплоходные прогулки по Волге, круизы в расположенные вдоль реки города – Нижний Новгород, \n" +
                                "Казань, Волгоград, Тольятти.\n" +
                                "Футбол занимает особое место в жизни Самары. В городе базируется известный в России футбольный клуб «Крылья Советов», \n" +
                                "проходят матчи различных уровней, а местный стадион «Металлург» – один из самых посещаемых в российской Премьер-лиге. \n" +
                                "С историей самарского футбола знакомит городской музей. \n" +
                                "Самара один из 11 российских городов, в которых пройдут матчи ЧМ-2018."
                )
        );


        cities.add(
                new City("Пермь",
                        1_042_763, 1, 1, 24,
                        25, 48, 12,
                        "Пермь – город на востоке европейской части России, на берегу уральской реки Кама. Столица Пермского края. \n" +
                                "Промышленный, научный, культурный центр Урала. Третий по площади город России. Расстояние до Москвы – более 1 400 км. \n" +
                                "Пермь славится своей древней историей, известняковыми пещерами и бурными реками.\n" +
                                "В городе находятся 13 музеев, включая Пермскую государственную художественную галерею – хранилище всемирно известной коллекции пермской деревянной скульптуры, \n" +
                                "четыре государственных театра, не менее десяти кинотеатров. \n" +
                                "Пермский музей современной искусства PERMM известен далеко за пределами города.\n" +
                                " В галерее можно увидеть произведения российских и зарубежных художников, " +
                                "работающих в самых разных направлениях – от живописи и графики до видеоарта и перформанса."
                )
        );

        return cities;
    }
}