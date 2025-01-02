package service.menuproject.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurant is a Querydsl query type for Restaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurant extends EntityPathBase<Restaurant> {

    private static final long serialVersionUID = 2023382330L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurant restaurant = new QRestaurant("restaurant");

    public final TimePath<java.time.LocalTime> dinnerEndTime = createTime("dinnerEndTime", java.time.LocalTime.class);

    public final TimePath<java.time.LocalTime> dinnerStartTime = createTime("dinnerStartTime", java.time.LocalTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final TimePath<java.time.LocalTime> launchEndTime = createTime("launchEndTime", java.time.LocalTime.class);

    public final TimePath<java.time.LocalTime> launchStartTime = createTime("launchStartTime", java.time.LocalTime.class);

    public final StringPath location = createString("location");

    public final ListPath<Menu, QMenu> menuList = this.<Menu, QMenu>createList("menuList", Menu.class, QMenu.class, PathInits.DIRECT2);

    public final TimePath<java.time.LocalTime> morningEndTime = createTime("morningEndTime", java.time.LocalTime.class);

    public final TimePath<java.time.LocalTime> morningStartTime = createTime("morningStartTime", java.time.LocalTime.class);

    public final StringPath name = createString("name");

    public final QUniversity university;

    public QRestaurant(String variable) {
        this(Restaurant.class, forVariable(variable), INITS);
    }

    public QRestaurant(Path<? extends Restaurant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurant(PathMetadata metadata, PathInits inits) {
        this(Restaurant.class, metadata, inits);
    }

    public QRestaurant(Class<? extends Restaurant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.university = inits.isInitialized("university") ? new QUniversity(forProperty("university")) : null;
    }

}

