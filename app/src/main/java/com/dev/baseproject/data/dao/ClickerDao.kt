package com.dev.baseproject.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dev.baseproject.data.entity.ClickerEntity

@Dao
abstract class ClickerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg clickerEntity: ClickerEntity)

    @Delete
    abstract fun delete(vararg clickerEntity: ClickerEntity)

    @Delete
    abstract fun delete(models: List<ClickerEntity>)

    @Query("DELETE FROM clicker_entity WHERE idScript = :idScript")
    abstract fun deleteByScriptId(idScript: Int)

}