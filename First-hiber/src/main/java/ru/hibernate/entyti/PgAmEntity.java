package ru.hibernate.entyti;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pg_am", schema = "pg_catalog", catalog = "postgres")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PgAmEntity {
    @Basic
    @Column(name = "oid", nullable = false)
    private byte[] oid;

    @Basic
    @Column(name = "amname", nullable = false)
    private Object amname;

    @Basic
    @Column(name = "amhandler", nullable = false)
    private Object amhandler;
    @Basic
    @Column(name = "amtype", nullable = false, length = -1)
    private Object amtype;

}
