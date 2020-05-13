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
  class Entitlements
    attr_accessor :id

    attr_accessor :authorized_weight

    attr_accessor :dependents_authorized

    attr_accessor :non_temporary_storage

    attr_accessor :privately_owned_vehicle

    attr_accessor :pro_gear_weight

    attr_accessor :pro_gear_weight_spouse

    attr_accessor :storage_in_transit

    attr_accessor :total_weight

    attr_accessor :total_dependents

    attr_accessor :e_tag

    # Attribute mapping from ruby-style variable name to JSON key.
    def self.attribute_map
      {
        :'id' => :'id',
        :'authorized_weight' => :'authorizedWeight',
        :'dependents_authorized' => :'dependentsAuthorized',
        :'non_temporary_storage' => :'nonTemporaryStorage',
        :'privately_owned_vehicle' => :'privatelyOwnedVehicle',
        :'pro_gear_weight' => :'proGearWeight',
        :'pro_gear_weight_spouse' => :'proGearWeightSpouse',
        :'storage_in_transit' => :'storageInTransit',
        :'total_weight' => :'totalWeight',
        :'total_dependents' => :'totalDependents',
        :'e_tag' => :'eTag'
      }
    end

    # Attribute type mapping.
    def self.swagger_types
      {
        :'id' => :'String',
        :'authorized_weight' => :'Integer',
        :'dependents_authorized' => :'BOOLEAN',
        :'non_temporary_storage' => :'BOOLEAN',
        :'privately_owned_vehicle' => :'BOOLEAN',
        :'pro_gear_weight' => :'Integer',
        :'pro_gear_weight_spouse' => :'Integer',
        :'storage_in_transit' => :'Integer',
        :'total_weight' => :'Integer',
        :'total_dependents' => :'Integer',
        :'e_tag' => :'String'
      }
    end

    # Initializes the object
    # @param [Hash] attributes Model attributes in the form of hash
    def initialize(attributes = {})
      return unless attributes.is_a?(Hash)

      # convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h| h[k.to_sym] = v }

      if attributes.has_key?(:'id')
        self.id = attributes[:'id']
      end

      if attributes.has_key?(:'authorizedWeight')
        self.authorized_weight = attributes[:'authorizedWeight']
      end

      if attributes.has_key?(:'dependentsAuthorized')
        self.dependents_authorized = attributes[:'dependentsAuthorized']
      end

      if attributes.has_key?(:'nonTemporaryStorage')
        self.non_temporary_storage = attributes[:'nonTemporaryStorage']
      end

      if attributes.has_key?(:'privatelyOwnedVehicle')
        self.privately_owned_vehicle = attributes[:'privatelyOwnedVehicle']
      end

      if attributes.has_key?(:'proGearWeight')
        self.pro_gear_weight = attributes[:'proGearWeight']
      end

      if attributes.has_key?(:'proGearWeightSpouse')
        self.pro_gear_weight_spouse = attributes[:'proGearWeightSpouse']
      end

      if attributes.has_key?(:'storageInTransit')
        self.storage_in_transit = attributes[:'storageInTransit']
      end

      if attributes.has_key?(:'totalWeight')
        self.total_weight = attributes[:'totalWeight']
      end

      if attributes.has_key?(:'totalDependents')
        self.total_dependents = attributes[:'totalDependents']
      end

      if attributes.has_key?(:'eTag')
        self.e_tag = attributes[:'eTag']
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
      true
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          id == o.id &&
          authorized_weight == o.authorized_weight &&
          dependents_authorized == o.dependents_authorized &&
          non_temporary_storage == o.non_temporary_storage &&
          privately_owned_vehicle == o.privately_owned_vehicle &&
          pro_gear_weight == o.pro_gear_weight &&
          pro_gear_weight_spouse == o.pro_gear_weight_spouse &&
          storage_in_transit == o.storage_in_transit &&
          total_weight == o.total_weight &&
          total_dependents == o.total_dependents &&
          e_tag == o.e_tag
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Fixnum] Hash code
    def hash
      [id, authorized_weight, dependents_authorized, non_temporary_storage, privately_owned_vehicle, pro_gear_weight, pro_gear_weight_spouse, storage_in_transit, total_weight, total_dependents, e_tag].hash
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