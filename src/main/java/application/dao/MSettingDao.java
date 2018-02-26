package application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import application.entity.MSetting;
import ninja.cero.sqltemplate.core.SqlTemplate;

/**
 * 設定マスタDAO
 */
@Component
public class MSettingDao {

    @Autowired
    private SqlTemplate sqlTemplate;

    /**
     * 設定マスタ情報を取得する
     *
     * @return 設定マスタエンティティ
     */
    public Optional<MSetting> select() {
        return Optional.ofNullable(sqlTemplate.forObject("sql/MSettingDao/select.sql", MSetting.class));
    }

    /**
     * 設定マスタ情報を追加する
     *
     * @param entity 設定マスタエンティティ
     * @return 更新件数
     */
    public int insert(MSetting entity) {
        return sqlTemplate.update("sql/MSettingDao/insert.sql", entity);
    }

    /**
     * 設定マスタ情報を更新する
     *
     * @param entity 設定マスタエンティティ
     * @return 更新件数
     */
    public int update(MSetting entity) {
        return sqlTemplate.update("sql/MSettingDao/update.sql", entity);
    }
}
