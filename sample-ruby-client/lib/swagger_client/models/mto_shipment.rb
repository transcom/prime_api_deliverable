=begin
#move.mil API

#The Prime API for move.mil

OpenAPI spec version: 0.0.1
Contact: dp3@truss.works
Generated by: https://github.com/swagger-api/swagger-codegen.git
Swagger Codegen version: 2.4.13

=end

require 'date'

module SwaggerClient
  class MTOShipment
    attr_accessor :move_task_order_id

    attr_accessor :id

    attr_accessor :created_at

    attr_accessor :updated_at

    attr_accessor :approved_date

    attr_accessor :scheduled_pickup_date

    attr_accessor :requested_pickup_date

    attr_accessor :first_available_delivery_date

    attr_accessor :prime_actual_weight

    attr_accessor :prime_estimated_weight

    attr_accessor :prime_estimated_weight_recorded_date

    attr_accessor :actual_pickup_date

    attr_accessor :required_delivery_date

    attr_accessor :agents

    attr_accessor :customer_remarks

    attr_accessor :shipment_type

    attr_accessor :pickup_address

    attr_accessor :destination_address

    attr_accessor :secondary_pickup_address

    attr_accessor :secondary_delivery_address

    attr_accessor :e_tag

    attr_accessor :status

    # Email or id of a contact person for this update.
    attr_accessor :point_of_contact

    class EnumAttributeValidator
      attr_reader :datatype
      attr_reader :allowable_values

      def initialize(datatype, allowable_values)
        @allowable_values = allowable_values.map do |value|
          case datatype.to_s
          when /Integer/i
            value.to_i
          when /Float/i
            value.to_f
          else
            value
          end
        end
      end

      def valid?(value)
        !value || allowable_values.include?(value)
      end
    end

    # Attribute mapping from ruby-style variable name to JSON key.
    def self.attribute_map
      {
        :'move_task_order_id' => :'moveTaskOrderID',
        :'id' => :'id',
        :'created_at' => :'createdAt',
        :'updated_at' => :'updatedAt',
        :'approved_date' => :'approvedDate',
        :'scheduled_pickup_date' => :'scheduledPickupDate',
        :'requested_pickup_date' => :'requestedPickupDate',
        :'first_available_delivery_date' => :'firstAvailableDeliveryDate',
        :'prime_actual_weight' => :'primeActualWeight',
        :'prime_estimated_weight' => :'primeEstimatedWeight',
        :'prime_estimated_weight_recorded_date' => :'primeEstimatedWeightRecordedDate',
        :'actual_pickup_date' => :'actualPickupDate',
        :'required_delivery_date' => :'requiredDeliveryDate',
        :'agents' => :'agents',
        :'customer_remarks' => :'customerRemarks',
        :'shipment_type' => :'shipmentType',
        :'pickup_address' => :'pickupAddress',
        :'destination_address' => :'destinationAddress',
        :'secondary_pickup_address' => :'secondaryPickupAddress',
        :'secondary_delivery_address' => :'secondaryDeliveryAddress',
        :'e_tag' => :'eTag',
        :'status' => :'status',
        :'point_of_contact' => :'pointOfContact'
      }
    end

    # Attribute type mapping.
    def self.swagger_types
      {
        :'move_task_order_id' => :'String',
        :'id' => :'String',
        :'created_at' => :'String',
        :'updated_at' => :'String',
        :'approved_date' => :'Date',
        :'scheduled_pickup_date' => :'Date',
        :'requested_pickup_date' => :'Date',
        :'first_available_delivery_date' => :'Date',
        :'prime_actual_weight' => :'Integer',
        :'prime_estimated_weight' => :'Integer',
        :'prime_estimated_weight_recorded_date' => :'Date',
        :'actual_pickup_date' => :'Date',
        :'required_delivery_date' => :'Date',
        :'agents' => :'MTOAgents',
        :'customer_remarks' => :'String',
        :'shipment_type' => :'MTOShipmentType',
        :'pickup_address' => :'Address',
        :'destination_address' => :'Address',
        :'secondary_pickup_address' => :'Address',
        :'secondary_delivery_address' => :'Address',
        :'e_tag' => :'String',
        :'status' => :'String',
        :'point_of_contact' => :'String'
      }
    end

    # Initializes the object
    # @param [Hash] attributes Model attributes in the form of hash
    def initialize(attributes = {})
      return unless attributes.is_a?(Hash)

      # convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h| h[k.to_sym] = v }

      if attributes.has_key?(:'moveTaskOrderID')
        self.move_task_order_id = attributes[:'moveTaskOrderID']
      end

      if attributes.has_key?(:'id')
        self.id = attributes[:'id']
      end

      if attributes.has_key?(:'createdAt')
        self.created_at = attributes[:'createdAt']
      end

      if attributes.has_key?(:'updatedAt')
        self.updated_at = attributes[:'updatedAt']
      end

      if attributes.has_key?(:'approvedDate')
        self.approved_date = attributes[:'approvedDate']
      end

      if attributes.has_key?(:'scheduledPickupDate')
        self.scheduled_pickup_date = attributes[:'scheduledPickupDate']
      end

      if attributes.has_key?(:'requestedPickupDate')
        self.requested_pickup_date = attributes[:'requestedPickupDate']
      end

      if attributes.has_key?(:'firstAvailableDeliveryDate')
        self.first_available_delivery_date = attributes[:'firstAvailableDeliveryDate']
      end

      if attributes.has_key?(:'primeActualWeight')
        self.prime_actual_weight = attributes[:'primeActualWeight']
      end

      if attributes.has_key?(:'primeEstimatedWeight')
        self.prime_estimated_weight = attributes[:'primeEstimatedWeight']
      end

      if attributes.has_key?(:'primeEstimatedWeightRecordedDate')
        self.prime_estimated_weight_recorded_date = attributes[:'primeEstimatedWeightRecordedDate']
      end

      if attributes.has_key?(:'actualPickupDate')
        self.actual_pickup_date = attributes[:'actualPickupDate']
      end

      if attributes.has_key?(:'requiredDeliveryDate')
        self.required_delivery_date = attributes[:'requiredDeliveryDate']
      end

      if attributes.has_key?(:'agents')
        self.agents = attributes[:'agents']
      end

      if attributes.has_key?(:'customerRemarks')
        self.customer_remarks = attributes[:'customerRemarks']
      end

      if attributes.has_key?(:'shipmentType')
        self.shipment_type = attributes[:'shipmentType']
      end

      if attributes.has_key?(:'pickupAddress')
        self.pickup_address = attributes[:'pickupAddress']
      end

      if attributes.has_key?(:'destinationAddress')
        self.destination_address = attributes[:'destinationAddress']
      end

      if attributes.has_key?(:'secondaryPickupAddress')
        self.secondary_pickup_address = attributes[:'secondaryPickupAddress']
      end

      if attributes.has_key?(:'secondaryDeliveryAddress')
        self.secondary_delivery_address = attributes[:'secondaryDeliveryAddress']
      end

      if attributes.has_key?(:'eTag')
        self.e_tag = attributes[:'eTag']
      end

      if attributes.has_key?(:'status')
        self.status = attributes[:'status']
      end

      if attributes.has_key?(:'pointOfContact')
        self.point_of_contact = attributes[:'pointOfContact']
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      invalid_properties = Array.new
      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      status_validator = EnumAttributeValidator.new('String', ['APPROVED', 'SUBMITTED', 'REJECTED'])
      return false unless status_validator.valid?(@status)
      true
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] status Object to be assigned
    def status=(status)
      validator = EnumAttributeValidator.new('String', ['APPROVED', 'SUBMITTED', 'REJECTED'])
      unless validator.valid?(status)
        fail ArgumentError, 'invalid value for "status", must be one of #{validator.allowable_values}.'
      end
      @status = status
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          move_task_order_id == o.move_task_order_id &&
          id == o.id &&
          created_at == o.created_at &&
          updated_at == o.updated_at &&
          approved_date == o.approved_date &&
          scheduled_pickup_date == o.scheduled_pickup_date &&
          requested_pickup_date == o.requested_pickup_date &&
          first_available_delivery_date == o.first_available_delivery_date &&
          prime_actual_weight == o.prime_actual_weight &&
          prime_estimated_weight == o.prime_estimated_weight &&
          prime_estimated_weight_recorded_date == o.prime_estimated_weight_recorded_date &&
          actual_pickup_date == o.actual_pickup_date &&
          required_delivery_date == o.required_delivery_date &&
          agents == o.agents &&
          customer_remarks == o.customer_remarks &&
          shipment_type == o.shipment_type &&
          pickup_address == o.pickup_address &&
          destination_address == o.destination_address &&
          secondary_pickup_address == o.secondary_pickup_address &&
          secondary_delivery_address == o.secondary_delivery_address &&
          e_tag == o.e_tag &&
          status == o.status &&
          point_of_contact == o.point_of_contact
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Fixnum] Hash code
    def hash
      [move_task_order_id, id, created_at, updated_at, approved_date, scheduled_pickup_date, requested_pickup_date, first_available_delivery_date, prime_actual_weight, prime_estimated_weight, prime_estimated_weight_recorded_date, actual_pickup_date, required_delivery_date, agents, customer_remarks, shipment_type, pickup_address, destination_address, secondary_pickup_address, secondary_delivery_address, e_tag, status, point_of_contact].hash
    end

    # Builds the object from hash
    # @param [Hash] attributes Model attributes in the form of hash
    # @return [Object] Returns the model itself
    def build_from_hash(attributes)
      return nil unless attributes.is_a?(Hash)
      self.class.swagger_types.each_pair do |key, type|
        if type =~ /\AArray<(.*)>/i
          # check to ensure the input is an array given that the attribute
          # is documented as an array but the input is not
          if attributes[self.class.attribute_map[key]].is_a?(Array)
            self.send("#{key}=", attributes[self.class.attribute_map[key]].map { |v| _deserialize($1, v) })
          end
        elsif !attributes[self.class.attribute_map[key]].nil?
          self.send("#{key}=", _deserialize(type, attributes[self.class.attribute_map[key]]))
        end # or else data not found in attributes(hash), not an issue as the data can be optional
      end

      self
    end

    # Deserializes the data based on type
    # @param string type Data type
    # @param string value Value to be deserialized
    # @return [Object] Deserialized data
    def _deserialize(type, value)
      case type.to_sym
      when :DateTime
        DateTime.parse(value)
      when :Date
        Date.parse(value)
      when :String
        value.to_s
      when :Integer
        value.to_i
      when :Float
        value.to_f
      when :BOOLEAN
        if value.to_s =~ /\A(true|t|yes|y|1)\z/i
          true
        else
          false
        end
      when :Object
        # generic object (usually a Hash), return directly
        value
      when /\AArray<(?<inner_type>.+)>\z/
        inner_type = Regexp.last_match[:inner_type]
        value.map { |v| _deserialize(inner_type, v) }
      when /\AHash<(?<k_type>.+?), (?<v_type>.+)>\z/
        k_type = Regexp.last_match[:k_type]
        v_type = Regexp.last_match[:v_type]
        {}.tap do |hash|
          value.each do |k, v|
            hash[_deserialize(k_type, k)] = _deserialize(v_type, v)
          end
        end
      else # model
        temp_model = SwaggerClient.const_get(type).new
        temp_model.build_from_hash(value)
      end
    end

    # Returns the string representation of the object
    # @return [String] String presentation of the object
    def to_s
      to_hash.to_s
    end

    # to_body is an alias to to_hash (backward compatibility)
    # @return [Hash] Returns the object in the form of hash
    def to_body
      to_hash
    end

    # Returns the object in the form of hash
    # @return [Hash] Returns the object in the form of hash
    def to_hash
      hash = {}
      self.class.attribute_map.each_pair do |attr, param|
        value = self.send(attr)
        next if value.nil?
        hash[param] = _to_hash(value)
      end
      hash
    end

    # Outputs non-array value in the form of hash
    # For object, use to_hash. Otherwise, just return the value
    # @param [Object] value Any valid value
    # @return [Hash] Returns the value in the form of hash
    def _to_hash(value)
      if value.is_a?(Array)
        value.compact.map { |v| _to_hash(v) }
      elsif value.is_a?(Hash)
        {}.tap do |hash|
          value.each { |k, v| hash[k] = _to_hash(v) }
        end
      elsif value.respond_to? :to_hash
        value.to_hash
      else
        value
      end
    end

  end
end