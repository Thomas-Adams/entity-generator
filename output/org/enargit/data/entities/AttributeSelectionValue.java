
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.NoArgsConstructor;
    import lombok.experimental.SuperBuilder;
    import org.hibernate.envers.Audited;
    import javax.persistence.*;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Size;
    import java.util.ArrayList;
    import java.util.List;
    import java.io.Serializable;
    import java.time.Instant;
    import java.time.LocalDateTime;
    import java.util.Optional;
    import java.util.TimeZone;

    @Table(name="attribute_selection_value")
    @Entity
class AttributeSelectionValue extends BaseEntity<Integer>{


            @Column(name="id", nullable = false )
        private Integer id;
                @Column(name="name", nullable = false , length = 2147483647 )
        private String name;
                @Column(name="order_number" )
        private Integer orderNumber;
                @Column(name="description" )
        private String description;
                @Column(name="tooltip" )
        private String tooltip;
                        @ManyToOne
        @JoinColumn(name="status", referencedColumnName="id"),
        private AttributeStatus StatusAttributeStatus;
                        @Column(name="version", nullable = false )
        private Integer version;
                        @ManyToOne
        @JoinColumn(name="selection_list_id", referencedColumnName="id"),
        private AttributeSelectionList SelectionListIdAttributeSelectionList;
                        @Column(name="created", nullable = false )
        private java.sql.Timestamp created;
                        @ManyToOne
        @JoinColumn(name="created_by", referencedColumnName="username"),
        private User CreatedByUser;
                        @Column(name="modified" )
        private java.sql.Timestamp modified;
                        @ManyToOne
        @JoinColumn(name="modified_by", referencedColumnName="username"),
        private User ModifiedByUser;
            

}