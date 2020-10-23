package dev.yukiho.homment.db.mapper.advance;

import dev.yukiho.homment.db.model.Room;
import dev.yukiho.homment.model.RoomData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomAdvanceMapper {

    List<RoomData> selectByUserId(@Param("userId") int userId);
}
